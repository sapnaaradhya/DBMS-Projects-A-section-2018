# config.py

# Enable Flask's debugging features. Should be False in production
DEBUG = True

SECRET_KEY = 'dev'

from app import app
import os
DATABASE = os.path.join(app.instance_path, 'app.sql')