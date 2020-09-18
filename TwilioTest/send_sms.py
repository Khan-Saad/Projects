from twilio.rest import Client
import os

account_sid = os.environ['TWILIO_ACCOUNT_SID']
auth_token = os.environ['TWILIO_ACCOUNT_AUTH_TOKEN']

client = Client(account_sid, auth_token)

message = client.messages.create(
        body="Join Earth's mightiest heroes. Like Kevin Bacon.",
        from_='+13605870947',
        to='+16472192778'
        )

print(message.sid)
