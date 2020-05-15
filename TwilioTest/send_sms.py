
from twilio.rest import Client

account_sid = 'nope'
auth_token = 'nope'
client = Client(account_sid, auth_token)

message = client.messages.create(
        body="Join Earth's mightiest heroes. Like Kevin Bacon.",
        from_='+15342203741',
        to='+16472192778'
        )

print(message.sid)
