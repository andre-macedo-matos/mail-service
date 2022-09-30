# mail-service
Springboot service to send email on website

### To use as a service, set the enviroment variables as follows:
  - EMAIL_USER: the email which will send the message from the website
  - EMAIL_PASS: the password of the email wich will send the message
  - EMAIL_USER_BCC: a second email occult to the website user, for control


### Then, in the form, set the action as *** project/send ***, which have to include the follows parameters:
  - name of the user of the form
  - email the email of the user of the form
  - message the message of user of the form
  
This will send a default message to the user of the form and a occult copy of the message to the email set in EMAIL_USER_BCC.

### The project is set to use gmail, remember to configure the [App Password from gmail](https://support.google.com/accounts/answer/185833?hl=en).
