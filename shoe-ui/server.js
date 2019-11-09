const express = require('express');
const next = require('next');
const ClientOAuth2 = require('client-oauth2');
const dev = process.env.NODE_ENV !== 'production';
const app = next({dev});
const handle = app.getRequestHandler();
const port = process.env.PORT || 8080;
const compression = require('compression');
const API_HOST_LOCAL = 'http://localhost:8080';
const API_HOST_DOCKER = 'http://shoe-service:8080';
const API_AUTHORIZATION_HOST_LOCAL = 'http://localhost:8090/auth/oauth/token';
const API_AUTHORIZATION_HOST_DOCKER = 'http://authorization-server:8090/auth/oauth/token';
const API_AUTHORIZATION_SERVER = dev ? API_AUTHORIZATION_HOST_LOCAL : API_AUTHORIZATION_HOST_DOCKER;
const API_HOST = dev ? API_HOST_LOCAL : API_HOST_DOCKER;

const shoeAuth = new ClientOAuth2({
    clientId: 'client',
    clientSecret: 'secret',
    accessTokenUri: API_AUTHORIZATION_SERVER,
    scopes: ['shoes']
});

const retrieveAuthTokens = async function () {
    await shoeAuth.credentials.getToken()
        .then(function (user) {
            token = user;
            accessToken = user.accessToken;
        })
};

let token = undefined;
let accessToken = undefined;

const devProxy = {
    '/api': {
        target: API_HOST,
        pathRewrite: {'^/api': ''},
        changeOrigin: true,
        onProxyReq(proxyReq, req, res) {
            if (!token || token.expired()) {
                retrieveAuthTokens();
            }
            proxyReq.setHeader('Authorization', 'Bearer ' + accessToken);
        }
    }
};

app
    .prepare()
    .then(() => {
        const server = express();
        server.use(compression());

        const proxyMiddleware = require('http-proxy-middleware');
        Object.keys(devProxy).forEach(function (context) {
            server.use(proxyMiddleware(context, devProxy[context]))
        });

        server.use(require('express-status-monitor')());

        server.get('*', (req, res) => {
            return handle(req, res)
        });

        server.listen(port, err => {
            if (err) throw err;
            console.log("process.env.NODE_ENV: " + JSON.stringify(process.env.NODE_ENV));
            console.log('> Ready on http://localhost:' + port + " process.env.PORT: " + process.env.PORT)
        })
    })
    .catch(ex => {
        console.error(ex.stack);
        process.exit(1)
    });
