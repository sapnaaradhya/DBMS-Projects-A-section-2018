from flask import Flask, render_template

app = Flask(__name__)

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/signin_student')
def signin_student():
    return render_template('signin_student.html')

@app.route('/signin_staff')
def signin_staff():
    return render_template('signin_staff.html')

@app.route('/signin_admin')
def signin_admin():
    return render_template('signin_admin.html')

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0')