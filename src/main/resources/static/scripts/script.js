const arrowBtns = document.querySelectorAll(".more-button");
const showcaseLists = document.querySelectorAll(".showcase-list");

window.addEventListener('DOMContentLoaded', function() {
    const buttons = document.querySelectorAll('.showcase-item-button');
    
    buttons.forEach(button => {
        button.addEventListener('click', function() {
            window.location.href = 'book-seats/1';
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

document.getElementById("search-icon").addEventListener("click", function(){
    const searchInput = document.getElementById("search-input");
    if(searchInput.style.display === "none" || searchInput.style.display === ""){
    searchInput.style.display = "block";
    searchInput.focus();
}
    else{
        searchInput.style.display = "none";
    }
});

document.getElementById('search-bar').addEventListener('input', function () {
    const query = this.value.toLowerCase().trim(); // Get the search query
    const movieItems = document.querySelectorAll('.showcase-item'); // Get all movie items

    movieItems.forEach(item => {
        const movieName = item.getAttribute('data-name').toLowerCase(); // Get the movie name
        if (movieName.includes(query)) {
            item.classList.remove('hidden'); // Show if it matches the query
        } else {
            item.classList.add('hidden'); // Hide if it doesn't match
        }
    });
});