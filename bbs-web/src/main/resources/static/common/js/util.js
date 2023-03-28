/*UI 이벤트 함수*/
const validForm = (form) => {
    if (form.checkValidity() === false) {
        form.classList.add("was-validated");
        return false;
    }

    return true;
}