#!/bin/sh
# gnu sed is required
# USAGE: ./sparql2datalog q1.sparql > q1.dl

VAR='?\([A-Za-z][A-Za-z0-9]\)\+'
ID='[A-Za-z0-9]\+'

cat $1 | \
grep -v "^#" | \
sed "s/^WHERE.*$/:-/g" | \
grep -v 'PREFIX' | \
sed "s/SELECT\s\+$VAR\s\+$VAR\s\+$VAR\s\+$VAR/ans(?\1, ?\2, ?\3, ?\4)/g" | \
sed "s/SELECT\s\+$VAR\s\+$VAR\s\+$VAR/ans(\1,?\2,\3)/g" | \
sed "s/SELECT\s\+$VAR\s\+$VAR/ans(\1,\2)/g" | \
sed "s/SELECT\s\+$VAR/ans(\1)/g" | \
sed "s/\s*$VAR\s\+a\s\+$ID:\($ID\)\s\+./\2(\1),/g" | \
sed "s/\s*$VAR\s\+$ID:\($ID\)\s\+$VAR\s\+./\2(\1,\3),/g" | \
sed "s/}//g" | \
tr "\\n" " " | \
sed "s/\,\s*$/./g"
