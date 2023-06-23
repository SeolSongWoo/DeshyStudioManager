import Fetch from "../Fetch.js";

export default class VendorSalesServerRequest extends Fetch {
    constructor() {
        super('/api/vendor/sales');
    }

    async getTopVolumeVendorsByLimits(limit) {
        return await this.fetch({
            url: `/volume/${limit}`,
            httpMethod: 'GET',
        });
    }
}