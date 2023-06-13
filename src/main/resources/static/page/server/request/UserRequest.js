import Fetch from "./Fetch.js";

export default class UserRequest extends Fetch{

    async signUp(url,body) {
        const jsonResponse = await this.fetch({
            url:url,
            httpMethod:'POST',
            body:body,
        })
        return jsonResponse;
    }
}