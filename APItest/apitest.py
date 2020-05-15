import requests

url = "https://alexnormand-dino-ipsum.p.rapidapi.com/"

querystring = {"format":"html","words":"30","paragraphs":"30"}

headers = {
    'x-rapidapi-host': "alexnormand-dino-ipsum.p.rapidapi.com",
    'x-rapidapi-key': "00ea94dd21msh3d562fddd177194p1d15f5jsn63e1fb862415"
    }

response = requests.request("GET", url, headers=headers, params=querystring)

print(response.text)
