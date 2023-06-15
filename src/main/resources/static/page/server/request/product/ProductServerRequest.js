import Fetch from "../Fetch.js";

export default class ProductServerRequest extends Fetch {
    constructor() {
        super('/api/products');
    }
}