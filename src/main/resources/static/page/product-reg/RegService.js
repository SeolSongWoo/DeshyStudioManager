import ProductServerRequest from "../server/request/product/ProductServerRequest.js";

export default class ProductRegService {
    constructor() {
        this.productServerRequest = new ProductServerRequest();
    }

    async registration(body) {
        return await this.productServerRequest.registration(body);
    }
}