import ProductRegUI from "./RegUI.js";
const regUI = new ProductRegUI();

export function initializeProductRegPage () {
    regUI.addProductRegButtonClickEvent(document.getElementById('productRegBtn'));
    regUI.addCategoryRegButtonClickEvent(document.getElementById('categoryRegBtn'));
    initSelectOption();
    initRemoveButton();
}

export const initSelectOption = async () => {
    return Promise.all([
        regUI.addSelectOption(document.getElementById('category-product'),"getCategory"),
        regUI.addSelectOption(document.getElementById('category-size'),"getCategory")
    ])
}

export const initRemoveButton = () => {
    return Promise.all([
        regUI.addCategoryButton(document.getElementById('registered-category'))
])
}