const express = require('express');
const next = require('next');

const dev = process.env.NODE_ENV !== 'production';
const app = next({dev});
const handle = app.getRequestHandler();
const port = process.env.PORT || 8080;
const compression = require('compression');
// const cors = require('cors');
const proxy = require('http-proxy-middleware');

app
    .prepare()
    .then(() => {
        const server = express();
        server.use(compression());
        // server.use(cors());
        // server.options('*', cors());
        // server.use(function(req, res, next) {
        //     res.header("Access-Control-Allow-Origin", "*"); // allow requests from any other server
        //     res.header('Access-Control-Allow-Methods', 'GET,PUT,POST,DELETE'); // allow these verbs
            // res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Cache-Control");
        // });

        // server.use(
        //     '/api',
        //     proxy({ target: 'http://localhost:8080'})
        // );

        server.get('*', (req, res) => {
            return handle(req, res)
        });

        // server.get('*', (req, res, next) => {
        //     return handle(req, res, next)
        // });

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
