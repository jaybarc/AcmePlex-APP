const arrowBtns = document.querySelectorAll(".more-button");
const showcaseLists = document.querySelectorAll(".showcase-list");

window.addEventListener('DOMContentLoaded', function() {
    const buttons = document.querySelectorAll('.showcase-item-button');
    
    buttons.forEach(button => {
        button.addEventListener('click', function() {
            window.location.href = 'book-seats';
        });
    });
});



arrowBtns.forEach((arrow, i)=>{
    const length = showcaseLists[i].querySelectorAll("img").length;
    let count = 0;
    arrow.addEventListener("click", ()=>{
        count++;
        if(length - (4 + count) > 0){
            showcaseLists[i].style.transform = `translateX(${
                showcaseLists[i].computedStyleMap().get("transform")[0].x.value -200
            }px)`;
 
        }
        else{
            showcaseLists[i].style.transform = "translateX(0)";
            count = 0;
        }
        //May want to fix margin on scroll right doesnt matter rn
    })

});