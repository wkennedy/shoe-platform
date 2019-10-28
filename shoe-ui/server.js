const express = require('express');
const next = require('next');

const dev = process.env.NODE_ENV !== 'production';
const app = next({dev});
const handle = app.getRequestHandler();
const port = process.env.PORT || 8080;
const compression = require('compression');
const DEV_API_HOST = 'http://localhost:8080';

const devProxy = {
    '/api': {
        target: DEV_API_HOST,
        pathRewrite: {'^/api': ''},
        changeOrigin: true
    }
};

app
    .prepare()
    .then(() => {
        const server = express();
        server.use(compression());

        if (dev && devProxy) {
            const proxyMiddleware = require('http-proxy-middleware');
            Object.keys(devProxy).forEach(function (context) {
                server.use(proxyMiddleware(context, devProxy[context]))
            })
        }

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
