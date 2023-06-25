import Fetch from "../Fetch.js";

export default class VendorServerRequest extends Fetch {
    constructor() {
        super('/api/vendor');
    }
}