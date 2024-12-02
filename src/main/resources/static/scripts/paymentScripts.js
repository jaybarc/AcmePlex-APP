window.addEventListener('DOMContentLoaded', function() {
    const cancelButton = document.querySelector('.btn.cancel');  
    
    cancelButton.addEventListener('click', function() {
        window.location.href = '/book-seats/1';  
    });
});

window.addEventListener('DOMContentLoaded', function() {
    // Retrieve the number of selected seats from localStorage
    const seatCount = localStorage.getItem('seatCount');
    
    // Fixed ticket price
    const ticketPrice = 15;

    // Calculate the total price
    const totalPrice = seatCount * ticketPrice;

    // Display the seat count and total price on the payment page
    document.getElementById('seat-count').textContent = seatCount;
    document.getElementById('total-price').textContent = `$${totalPrice}`;
});
