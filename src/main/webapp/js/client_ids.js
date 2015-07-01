var location_https = window.location.href.indexOf('https://') === 0;


// Register your domain with Facebook at  and add here
var FACEBOOK_CLIENT_ID = {
	'http://localhost:8383/IntegradorVaoi/' : '625334010934576'
}[window.location.hostname];

//To make it a little easier
var CLIENT_IDS = {
		//windows : WINDOWS_CLIENT_ID,
		//google : GOOGLE_CLIENT_ID,
		facebook : FACEBOOK_CLIENT_ID
	};

var OAUTH_PROXY_URL = {
		'local.knarly.com' : 'http://local.knarly.com:5500/proxy'
	}[window.location.hostname] || 'https://auth-server.herokuapp.com/proxy';