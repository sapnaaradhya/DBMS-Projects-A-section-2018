# Created by Abhijeet Singh
# views.py

from flask import render_template

from app import app

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

@app.route('/student_home')
def student_home():
    return render_template('student_home.html')

@app.route('/admin_home')
def admin_home():
    return render_template('admin_home.html')

@app.route('/admin_create1')
def admin_create1():
    return render_template('admin_create1.html')

@app.route('/admin_create2')
def admin_create2():
    return render_template('admin_create2.html')