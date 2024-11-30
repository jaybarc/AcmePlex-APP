const tin = document.querySelector('.seat-tin');
const seats = document.querySelectorAll('.row .seat:not(.occupied)');
const count = document.getElementById('count');
const total = document.getElementById('total');
const screeningSelect = document.getElementById('screening');

populateSeats();
let ticketPrice = +screeningSelect.value;

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

    const countChosen =  chosenSeats.length;
    count.innerText = countChosen;
    total.innerText = countChosen * ticketPrice;

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
