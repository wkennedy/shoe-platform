const dev = process.env.NODE_ENV !== 'production';
export const API_HOST_LOCAL = 'http://localhost:8080';
export const API_HOST_DOCKER = 'http://shoe-service:8080';
export const API_HOST = dev ? API_HOST_LOCAL : API_HOST_DOCKER;

export const MONITOR_HOST_LOCAL = 'http://localhost:8091';
export const MONITOR_HOST_DOCKER = 'http://spring-boot-admin-server:8091';
export const MONITOR_HOST = dev ? MONITOR_HOST_LOCAL : MONITOR_HOST_DOCKER;

export const serviceHost = function() {
    return API_HOST_LOCAL;
};

export const apiHost = function (req) {
    return req ? `${req.protocol}://${req.get('Host')}` : '';
};