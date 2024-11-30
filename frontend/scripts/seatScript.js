const tin = document.querySelector('.seat-tin');
const seats = document.querySelectorAll('.row .seat:not(.occupied)');
const count = document.getElementById('count');
const total = document.getElementById('total');
const screeningSelect = document.getElementById('screening');

let ticketPrice = +screeningSelect.value;

tin.addEventListener('click', (e) => {
    if (e.target.classList.contains('seat') && !e.target.classList.contains('occupied')){
        e.target.classList.toggle('selected');
    }

})

