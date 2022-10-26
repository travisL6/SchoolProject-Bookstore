# SchoolProject-Bookstore
Final project for class: Bookstore with a gui using JavaFX. Created in Eclipse

When you start the program you will be prompted to login:
Username: tlambert
Password: 12345

I created an error label to show when the user inputs an incorrect username AND password. 
It will only show if the user clicks sign in when both fields are not empty for some reason.

When signed in you there will be a list of books. Books with buttons that are disabled are out of stock and 
when you check a book out it will disable the button for that book. The return button starts out disabled but 
enables when the user checks a book out. The return button returns the book to the store and removes it from the customer. 
It then re-enables the button for that book and disabled the return button again. Log out brings you back to the log in screen.
