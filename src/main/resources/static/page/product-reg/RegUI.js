import ProductRegService from "./RegService.js";
import Util from "../util/Util.js";

export default class ProductRegUI {
    constructor() {
        this.productRegService = new ProductRegService();
    }

    addProductRegButtonClickEvent(formElement) {
        formElement.addEventListener('submit', this.#ProductRegButtonClickEventHandler);
    }

    #ProductRegButtonClickEventHandler = async(e) => {
        e.preventDefault();
        if(!Util.checkValidity(e)) return;
        const regData = this.#getRegData(e.target);
        const regResult = await this.productRegService.createProduct(regData);
        if(regResult.status === 201) {
            alert('상품등록이 완료되었습니다.');
        } else if(regResult.status === 409) {
            alert('해당 상품이 이미 존재합니다.');
        } else {
            alert('상품등록에 실패하였습니다.잠시 후 다시 시도해주세요.');
        }
    }

    #getRegData(target) {
        const regData = {};
        regData.name = target.name.value;
        regData.vendor = target.vendor.value;
        regData.originPrice = target.originPrice.value;
        regData.size = target.size.value;
        regData.quantity = target.quantity.value;
        regData.category = target.category.value;
        regData.regDate = moment().format('YYYY-MM-DD');
        return regData;
    }

    addSizeRegButtonClickEvent(formElement) {
        formElement.addEventListener('submit',this.#sizeRegButtonClickEvent);
    }

    #sizeRegButtonClickEvent = async (e) => {
        e.preventDefault();
        if(!Util.checkValidity(e)) return;
        const sizeResult = await this.productRegService.createCategory({category:e.target.category.value});
        if(sizeResult.status === 201) {
            alert('카테고리 등록이 완료되었습니다.');
        } else if(sizeResult.status === 409) {
            alert('해당 카테고리가 이미 존재합니다.');
        } else {
            alert('카테고리 등록에 실패하였습니다.잠시 후 다시 시도해주세요.');
        }
    }

    addCategoryRegButtonClickEvent(elementById) {

    }
}