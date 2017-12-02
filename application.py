
from flask import Flask, request, render_template
import sqlite3

DATABASE = 'psykick.db'

app = Flask(__name__)

@app.route("/")
def index():
    db = getattr(g, '_database', None)
    if db is not None:
        db.close()
    return 'hello'
    # return render_template('index.html')

if __name__ == "__main__":
    app.run()