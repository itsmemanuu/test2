import gspread
import json
import os

# Load service account credentials
creds_json = json.loads(os.environ["GOOGLE_SERVICE_ACCOUNT_JSON"])
gc = gspread.service_account_from_dict(creds_json)

# Open the Google Sheet by name (or by URL or key)
sheet = gc.open("testWorkflow").sheet1

# Example: Append a row
sheet.append_row(["✅ Update from GitHub Actions!", "Works!"])
