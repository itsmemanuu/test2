import gspread
import json
import os
import json

creds_json = json.loads(os.environ["GOOGLE_SERVICE_ACCOUNT_JSON"])
gc = gspread.service_account_from_dict(creds_json)

sheet = gc.open("testWorkflow").sheet1

with open("report.json", "r") as f:
	data = json.load(f)
 
formatted = [f"{c['name']}, {c['percent']}" for c in data['contributors']]

formatted.insert(0, data['repo'])

sheet.append_row(formatted)
