
from flask import Flask, request, render_template, g, jsonify
import sqlite3

DATABASE = 'psykick.db'

app = Flask(__name__)


def get_db():
    db = getattr(g, '_database', None)
    if db is None:
        db = g._database = sqlite3.connect(DATABASE)
    return db

def query_db(query, args=(), one=False):
    cur = get_db().execute(query, args)
    rv = cur.fetchall()
    cur.close()
    return (rv[0] if rv else None) if one else rv

@app.route("/", methods=['GET', 'POST'])
def index():
    if request.method == 'POST':
        db = get_db()
        r = query_db("select * from student")
        return jsonify(students = r)
    
    return render_template('index.html')

if __name__ == "__main__":
    app.run(debug=True)
