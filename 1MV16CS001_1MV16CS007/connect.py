import cx_Oracle

con = cx_Oracle.connect('student/student@//localhost:1521/xe')
print(con.version)

cur = con.cursor()
cur.execute("select * from student")

for result in cur:
    print(result)

con.close()
