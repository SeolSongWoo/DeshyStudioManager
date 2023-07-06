import ProductRegService from "./RegService.js";
import Util from "../util/Util.js";
import {initRemoveButton, initSelectOption} from "./RegIndex.js";

export default class ProductRegUI {
    constructor() {
        this.productRegService = new ProductRegService();
    }

    addProductRegButtonClickEvent(formElement) {
        formElement.addEventListener('submit', this.#ProductRegButtonClickEventHandler);
    }

    #ProductRegButtonClickEventHandler = async (e) => {
        e.preventDefault();
        if (!Util.checkValidity(e)) return;
        const regData = this.#getRegData(e.target);
        const regResult = await this.productRegService.createProduct(regData);
        if (regResult.status === 201) {
            alert('상품등록이 완료되었습니다.');
        } else if (regResult.status === 409) {
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


    addCategoryRegButtonClickEvent(formElement) {
        formElement.addEventListener('submit', this.#categoryRegButtonClickEventHandler);
    }

    #categoryRegButtonClickEventHandler = async (e) => {
        e.preventDefault();
        if (!Util.checkValidity(e)) return;
        const sizeResult = await this.productRegService.createCategory({category: e.target.category.value});
        if (sizeResult.status === 201) {
            await initRemoveButton();
            await initSelectOption();
            alert('카테고리 등록이 완료되었습니다.');
        } else if (sizeResult.status === 409) {
            alert('해당 카테고리가 이미 존재합니다.');
        } else {
            alert('카테고리 등록에 실패하였습니다.잠시 후 다시 시도해주세요.');
        }
    }

    addSizeRegButtonClickEvent(elementById) {

    }

    async addSelectOption(elementById, serviceMethod) {
        while (elementById.options.length > 1) {
            elementById.remove(1);
        }
        const data = await this.productRegService[serviceMethod]();
        data.forEach(data => {
            const option = document.createElement('option');
            option.value = data.uid;
            option.text = data.name;
            const firstOption = elementById.options[0];
            elementById.insertBefore(option, firstOption.nextSibling);
        })
    }

    async addCategoryButton(elementById) {
        elementById.innerHTML = '';
        const categoryList = await this.productRegService.getCategory();
        categoryList.forEach(category => {
            const button = this.addRemoveButton(category,'deleteCategory');
            elementById.appendChild(button);
        })
    }

    addRemoveButton(data,serviceMethod) {
        const div = document.createElement('div');
        div.classList.add('form-control','custom-pa-pm');
        div.style.width = 'auto';
        const button = document.createElement('button');
        button.type = 'button';
        button.classList.add('btn','btn-danger','btn-xs','custom-btn-size');
        button.textContent = data.name;
        button.value = data.uid;
        button.setAttribute('data-function',serviceMethod);
        button.addEventListener('click',this.#addRemoveButtonClickEventHandler);
        div.appendChild(button);
        return div;
    }

    #addRemoveButtonClickEventHandler = async (e) => {
        if(!confirm('정말로 삭제하시겠습니까?')) return;
        const uid = e.target.value;
        const serviceMethod = e.target.getAttribute('data-function');
        const deleteResult = await this.productRegService[serviceMethod](uid);
        if (deleteResult.status === 204) {
            await initRemoveButton();
            await initSelectOption();
            alert('삭제가 완료되었습니다.');
        }else {
            alert('삭제에 실패하였습니다.');
        }
    }
}