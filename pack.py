#!/usr/bin/python
# -*- coding: utf-8 -*-

import sys
import os
from subprocess import call

def print_usage():
    print("Usage: python pack.py assignment_number")

prefix = 'assignment-'
zh_num = ['零', '一', '二', '三', '四', '五',
          '六', '七', '八', '九', '十']

if len(sys.argv) > 1:
    try:
        n = int(sys.argv[1])
    except ValueError:
        print("Please input correct number!")
        print_usage()
        exit()
    upload_dir = prefix + "%02d" % n
    try:
        os.chdir(upload_dir)
    except FileNotFoundError:
        print("Please input correct number!")
        print_usage()
        exit()
    call(['make', 'clean'])
    os.chdir('../')
    call(['zip', '-r', 'upload/PB13011038 阴钰 第' + zh_num[n] +
          '次作业.zip', upload_dir])
else:
    print("Please input the assignment number!")
    print_usage()
    exit()
