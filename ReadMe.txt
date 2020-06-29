Since this framework is dedicated to testing only, we can put all non test related materials to
main folder.
Then, the whole idea of url design is that one is supposed to design things around resources.
so we have to concept resources such as bookings, and these will represented with /bookings or /customers etc.
And we kind of need to mimick that in our framework.

For example, we now have a BookingApi class which deals with requests for bookings.


When it comes to using 'assertThat' method from Hamcrest, this is mainly due to its being more readable and controllable.

*When we are going a post request, we have to tell api what contentType we are sending the payload.
We have done this by creating payloads classes, and we created constructors to use later.

Next, we are looking at authentication. Now, sometimes we need to get a token, and this was happening in cyclos.
