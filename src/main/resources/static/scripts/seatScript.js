//make variable names consistent

const tin = document.querySelector('.seat-tin');
const seats = document.querySelectorAll('.row .seat:not(.occupied)');
const count = document.getElementById('count');
const total = document.getElementById('total');
const screeningSelect = document.getElementById('screening');

fetchMovies();

function fetchMovies() {
    fetch('http://localhost:8080/movies')
        .then(response => response.json())
        .then(movies => {
            const screeningSelect = document.getElementById('screening');
            movies.forEach(movie => {
                const option = document.createElement('option');
                option.value = movie.price;
                option.textContent = movie.name;
                screeningSelect.appendChild(option);
            });
        })
        .catch(error => {
            console.error('Error fetching movies:', error);
        });
}

    window.addEventListener('DOMContentLoaded', function() {
        const button = document.querySelector('.payment-btn');  
        
        button.addEventListener('click', function() {
            // Get the number of selected seats
            const selectedSeats = document.querySelectorAll('.row .seat.selected');
            const seatCount = selectedSeats.length;

            // Store the seat count in localStorage
            localStorage.setItem('seatCount', seatCount);

            // Redirect to payment page
            window.location.href = 'payment';
        });
    });


/*
window.addEventListener('DOMContentLoaded', function() {
    const button = document.querySelector('.payment-btn');  
    
    button.addEventListener('click', function() {
        window.location.href = 'payment';  
    });
});
*/
//add cancel selection clears all seats button


populateSeats();
let ticketPrice = +screeningSelect.value;
let selectedSeatIds = [];

function setMovieData(index, price){
    localStorage.setItem('currentIndex', index)
    localStorage.setItem('currentPrice', price);

}


function selectedCount(){
    const chosenSeats = document.querySelectorAll('.row .seat.selected');

    const seatInfo = [...chosenSeats].map(function (seat){
        return [...seats].indexOf(seat);
    });

    console.log(seatInfo)

    //placeholder for backend
    localStorage.setItem('chosenSeats', JSON.stringify(seatInfo))
    
    // Get all selected seats and collect their 'data-id' attributes
    const selectedSeats = [];
    // Iterate over all selected seats and push the 'data-id' of those with the 'selected' class
    document.querySelectorAll('.seat.selected').forEach(selectedSeat => {
        const seatId = selectedSeat.getAttribute('data-id');
        // Only add to the array if the seatId is not null or empty
        if (seatId) {
            selectedSeats.push(seatId);
        }
    });
    
    // Store the selected seat IDs in localStorage
    localStorage.setItem('selectedSeats', JSON.stringify(selectedSeats));
    
    localStorage.setItem('movieId', screeningSelect.value);

    const countChosen =  chosenSeats.length;
    count.innerText = countChosen;

}



function populateSeats(){
    const selectedSeats = JSON.parse(localStorage.getItem('chosenSeats'))
    console.log(selectedSeats);

    if(selectedSeats !== null && selectedSeats.length > 0){
        seats.forEach((seat, index) => {
            if(selectedSeats.indexOf(index) > -1){
                seat.classList.add('selected');
            }

        })

    }
    const selectedMovieIndex = localStorage.getItem('currentIndex');

    if (selectedMovieIndex != null){
        screeningSelect.currentIndex = selectedMovieIndex;

    }

}

screeningSelect.addEventListener('change', (e) => {
    ticketPrice = +e.target.value;
    selectedCount();

})

tin.addEventListener('click', (e) => {
    if (e.target.classList.contains('seat') && !e.target.classList.contains('occupied')){
        e.target.classList.toggle('selected');
    }
   
    selectedCount();

})

selectedCount();


