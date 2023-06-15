export default class Fetch {

    constructor(url) {
        this.url = url;
    }
    async fetch(fetchOption) {
        fetchOption.url = fetchOption.url ? `${fetchOption.url}` : '';
        const _csrf = document.querySelector('input[name=_csrf]').value;
        let jsonResponse;
        try {
            const fetchInit = {};
            fetchInit.method = fetchOption.httpMethod;
            fetchInit.headers = {'Content-Type': 'application/json','X-XSRF-TOKEN':_csrf}
            if(fetchOption.body) fetchInit.body = JSON.stringify(fetchOption.body);
            const response = await fetch(`${this.url}/${fetchOption.url}`, fetchInit);
            jsonResponse = await response.json();
        } catch (error) {
            jsonResponse = error;
        }
        return jsonResponse;
    }
}