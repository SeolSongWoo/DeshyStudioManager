import UserRequest from "../server/request/UserRequest.js";

export default class SignUpService {
    constructor() {
        this.userRequest = new UserRequest();
    }

    async signUp(body) {
        return await this.userRequest.signUp('signup', body);
    }
}