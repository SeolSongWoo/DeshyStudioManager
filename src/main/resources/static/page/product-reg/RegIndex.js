import ProductRegUI from "./RegUI.js";
const regUI = new ProductRegUI();

export function initializeProductRegPage () {
    regUI.addProductRegButtonClickEvent(document.getElementById('productRegBtn'));
    regUI.addSizeRegButtonClickEvent(document.getElementById('sizeRegBtn'));
    regUI.addCategoryRegButtonClickEvent(document.getElementById('categoryRegBtn'));
}