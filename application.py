
from flask import Flask, request, render_template, g, jsonify, redirect, url_for
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

@app.route("/signup", methods=['GET', 'POST'])
def signup():
    if request.method == 'POST':
        # db = get_db()
        # r = query_db("select * from student")
        # return jsonify(students = r)
        student_id = request.form.get('student_id')
        password = request.form.get('password')
        
        students = query_db("SELECT student_id FROM student WHERE student_id=?", [student_id])
        if len(students) != 0:
            return "Bad request"
        else:
            print('well we got here')
            return redirect(url_for("index"))



    return render_template('signup.html')

if __name__ == "__main__":
    app.run(debug=True, port=8080)


