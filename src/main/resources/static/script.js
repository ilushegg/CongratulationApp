const signInBtn = document.querySelector('.signin-btn');
const signUpBtn = document.querySelector('.signup-btn');
const formBox = document.querySelector('.form-box');
const formContainer = document.querySelector('.form_container');
const signUpTitle = document.querySelector('.signup-title');

signUpBtn.addEventListener('click', function() {
    formBox.classList.add('active');
    formContainer.classList.add('active');
    signUpTitle.classList.remove('active');
});

signInBtn.addEventListener('click', function() {
    formBox.classList.remove('active');
    formContainer.classList.remove('active');
    signUpTitle.classList.add('active');
});