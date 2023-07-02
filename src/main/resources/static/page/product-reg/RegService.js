import ProductServerRequest from "../server/request/product/ProductServerRequest.js";
import ServerErrorHandle from "../exception/ServerErrorHandle.js";

export default class ProductRegService {
    constructor() {
        this.productServerRequest = new ProductServerRequest();
    }

    async createProduct(body) {
        return await this.productServerRequest.createProduct(body);
    }

    async createCategory(body) {
        return await this.productServerRequest.createCategory(body);
    }

    async getCategory() {
        const response = await this.productServerRequest.getCategory();
        return ServerErrorHandle.checkResponseStatus(response);
    }

    async deleteCategory(uid) {
        return await this.productServerRequest.deleteCategory(uid);
    }
}