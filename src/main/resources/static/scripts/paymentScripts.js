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

document.addEventListener('DOMContentLoaded', function () {
    const form = document.querySelector('form');
    const cancelButton = document.querySelector('.cancel');
    const submitButton = form.querySelector('button[type="submit"]');
    
    // Prevent form submission to handle it with JavaScript
    form.addEventListener('submit', function (e) {
        e.preventDefault(); // Prevent default form submission

        // Capture the form data
        const fullName = document.querySelector('input[name="full-name"]').value;
        const email = document.querySelector('input[name="email"]').value;
        const address = document.querySelector('input[name="address"]').value;
        const city = document.querySelector('input[name="city"]').value;
        const province = document.querySelector('input[name="province"]').value;
        const zipCode = document.querySelector('input[name="zip-code"]').value;

        const cardName = document.querySelector('input[name="card-name"]').value;
        const cardNumber = document.querySelector('input[name="card-number"]').value;
        const cardCVV = document.querySelector('input[name="card-cvv"]').value;
        const expMonth = document.querySelector('input[name="exp-month"]').value;
        const expYear = document.querySelector('input[name="exp-year"]').value;

        // Get the number of seats and total from localStorage
        const seatCount = localStorage.getItem('seatCount');
        const ticketPrice = 15; // Static price
        const totalPrice = seatCount * ticketPrice;

        // Create an object with all the data to send to the backend or show in the notification
        const paymentData = {
            fullName,
            email,
            address,
            city,
            province,
            zipCode,
            cardName,
            cardNumber,
            cardCVV,
            expMonth,
            expYear,
            seatCount,
            totalPrice
        };

        // Send payment data to the backend (for example, to save in the database and send an email)
        fetch('http://localhost:8080/process-payment', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(paymentData),
        })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                // Notify user of successful payment (this could be a modal, alert, or notification)
                alert('Payment successful! Thank you for your purchase.');

                // Redirect to the home page
                window.location.href = '/'; // Adjust the path to your home page
            } else {
                alert('Payment failed. Please try again.');
            }
        })
        .catch(error => {
            console.error('Error processing payment:', error);
            alert('An error occurred. Please try again.');
        });
    });

    // Handle cancel button to redirect to home page without submitting
    cancelButton.addEventListener('click', function () {
        window.location.href = '/'; // Adjust the path to your home page
    });

    // Optional: Trigger form submit on button click (if you need it to trigger the submit)
    submitButton.addEventListener('click', function () {
        form.submit(); // This triggers the form's submit event and runs the code inside the submit handler
    });
});
