import ProfitServerRequest from "../server/request/product/sales/ProfitServerRequest.js";
import ProductServerRequest from "../server/request/product/ProductServerRequest.js";
import RevenueServerRequest from "../server/request/product/sales/RevenueServerRequest.js";
import SalesVolumeServerRequest from "../server/request/product/sales/SalesVolumeServerRequest.js";

export default class HomeService {
    constructor() {
        this.productRequest = new ProductServerRequest();
        this.profitRequest = new ProfitServerRequest();
        this.revenueRequest = new RevenueServerRequest();
        this.salesVolumeRequest = new SalesVolumeServerRequest();
    }
}