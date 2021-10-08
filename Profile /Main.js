const hamburger = document.querySelector(".hamburger");
const menu = document.querySelector(".menu");
const navLink = document.querySelectorAll(".link");

hamburger.addEventListener("click", mobileMenu);
navLink.forEach(n => n.addEventListener("click", closeMenu))
function mobileMenu(){
    hamburger.classList.toggle("active");
    menu.classList.toggle("active");
}

function closeMenu(){
    hamburger.classList.remove("active");
    menu.classList.remove("active")
}