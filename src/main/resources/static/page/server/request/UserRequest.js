import Fetch from "./Fetch.js";

export default class UserRequest extends Fetch{
    constructor() {
        super('/api/users');
    }

    async signUp(body) {
        return await this.fetch({
            url: '/signup',
            httpMethod: 'POST',
            body: body,
        });
    }

}