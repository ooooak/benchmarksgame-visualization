### See which lang perform better in single area

TODO: (there are lots of things we can do but i dont think i am gonna put more time into it)


0. add tests.

1. improve code quality.

2. add user interface visualization (if someone is interested ping me i will be happy to help).

3. language to language comparison (as of now we only compare algorithms that exists in all the languages).


![Results](https://i.imgur.com/FbloDcg.jpg)

### how to run

> lein repl 

> (p (sort-by :secs added-sum))

> (p (sort-by :gz added-sum))

> (p (sort-by :mem added-sum))


> `:gz` for code size ,  `:secs` for speed, for memory usage `:mem`. 


### overall data 
```
{:lua
 {:spectral-norm {:gz 329, :mem 2872, :secs 192.8, :busy 199.44},
  :regex-redux {},
  :n-body {:gz 1305, :mem 1368, :secs 406.77, :busy 412.06},
  :pidigits {},
  :binary-trees {:gz 412, :mem 2358616, :secs 468.44, :busy 477.98},
  :mandelbrot {:gz 623, :mem 22712, :secs 256.77, :busy 899.1},
  :fannkuch-redux {:gz 462, :mem 1340, :secs 1317.39, :busy 1339.5},
  :k-nucleotide {:gz 613, :mem 521716, :secs 189.9, :busy 191.07},
  :reverse-complement
  {:gz 553, :mem 2932848, :secs 77.65, :busy 77.85},
  :fasta {:gz 1061, :mem 3056, :secs 51.34, :busy 51.87}},
 :go
 {:spectral-norm {:gz 548, :mem 2500, :secs 3.95, :busy 15.72},
  :regex-redux {:gz 802, :mem 438516, :secs 29.64, :busy 62.79},
  :n-body {:gz 1310, :mem 1588, :secs 21.25, :busy 21.43},
  :pidigits {:gz 603, :mem 8444, :secs 2.05, :busy 2.1},
  :binary-trees {:gz 1005, :mem 370688, :secs 25.4, :busy 87.09},
  :mandelbrot {:gz 905, :mem 31104, :secs 5.47, :busy 21.78},
  :fannkuch-redux {:gz 896, :mem 11672, :secs 17.53, :busy 70.01},
  :k-nucleotide {:gz 1607, :mem 160068, :secs 11.86, :busy 44.82},
  :reverse-complement {:gz 1338, :mem 1783340, :secs 3.55, :busy 6.26},
  :fasta {:gz 1358, :mem 3568, :secs 2.07, :busy 5.67}},
 :javascript
 {:spectral-norm {:gz 999, :mem 55256, :secs 4.27, :busy 16.34},
  :regex-redux {:gz 668, :mem 789500, :secs 10.49, :busy 12.86},
  :n-body {:gz 1297, :mem 34008, :secs 23.39, :busy 23.63},
  :pidigits {:gz 530, :mem 63844, :secs 12.74, :busy 13.01},
  :binary-trees {:gz 744, :mem 1087716, :secs 23.2, :busy 75.11},
  :mandelbrot {:gz 1122, :mem 83836, :secs 6.76, :busy 26.57},
  :fannkuch-redux {:gz 1316, :mem 53780, :secs 24.21, :busy 95.92},
  :k-nucleotide {:gz 1812, :mem 395204, :secs 26.52, :busy 76.74},
  :reverse-complement
  {:gz 1307, :mem 1100412, :secs 4.57, :busy 11.03},
  :fasta {:gz 2047, :mem 63744, :secs 3.38, :busy 9.63}},
 :chapel
 {:spectral-norm {:gz 310, :mem 5212, :secs 3.98, :busy 15.77},
  :regex-redux {:gz 477, :mem 629668, :secs 8.8, :busy 17.3},
  :n-body {:gz 962, :mem 5408, :secs 23.81, :busy 24.1},
  :pidigits {:gz 423, :mem 6224, :secs 1.63, :busy 1.7},
  :binary-trees {:gz 470, :mem 361836, :secs 14.35, :busy 46.65},
  :mandelbrot {:gz 620, :mem 36060, :secs 5.42, :busy 21.43},
  :fannkuch-redux {:gz 728, :mem 4080, :secs 15.59, :busy 62.16},
  :k-nucleotide {:gz 1042, :mem 293404, :secs 17.15, :busy 64.82},
  :reverse-complement {:gz 707, :mem 1497376, :secs 2.08, :busy 4.76},
  :fasta {:gz 1398, :mem 5812, :secs 1.61, :busy 5.63}},
 :haskell
 {:spectral-norm {:gz 987, :mem 4060, :secs 4.08, :busy 15.82},
  :regex-redux {:gz 2213, :mem 307968, :secs 1.72, :busy 3.77},
  :n-body {:gz 1883, :mem 4232, :secs 21.87, :busy 86.49},
  :pidigits {:gz 379, :mem 9296, :secs 4.21, :busy 5.24},
  :binary-trees {:gz 592, :mem 466176, :secs 13.34, :busy 49.53},
  :mandelbrot {:gz 782, :mem 39512, :secs 11.65, :busy 46.54},
  :fannkuch-redux {:gz 842, :mem 4296, :secs 18.37, :busy 72.64},
  :k-nucleotide {:gz 1486, :mem 756564, :secs 37.65, :busy 132.24},
  :reverse-complement {:gz 1020, :mem 501496, :secs 6.28, :busy 8.42},
  :fasta {:gz 1882, :mem 7900, :secs 1.43, :busy 4.25}},
 :pascal
 {:spectral-norm {:gz 542, :mem 1912, :secs 3.98, :busy 15.84},
  :regex-redux {:gz 1503, :mem 103124, :secs 3.88, :busy 5.35},
  :n-body {:gz 1325, :mem 8, :secs 22.36, :busy 22.46},
  :pidigits {:gz 530, :mem 2436, :secs 1.73, :busy 1.8},
  :binary-trees {:gz 1003, :mem 132852, :secs 3.06, :busy 10.34},
  :mandelbrot {:gz 974, :mem 29120, :secs 8.52, :busy 34.0},
  :fannkuch-redux {:gz 1050, :mem 1860, :secs 17.95, :busy 71.73},
  :k-nucleotide {},
  :reverse-complement {:gz 771, :mem 499600, :secs 7.86, :busy 7.93},
  :fasta {:gz 1140, :mem 8, :secs 10.96, :busy 11.09}},
 :lisp
 {:spectral-norm {:gz 899, :mem 16472, :secs 3.99, :busy 15.75},
  :regex-redux {},
  :n-body {:gz 1403, :mem 17364, :secs 26.25, :busy 26.74},
  :pidigits {:gz 493, :mem 129808, :secs 12.28, :busy 12.44},
  :binary-trees {:gz 943, :mem 309372, :secs 11.94, :busy 25.35},
  :mandelbrot {:gz 2473, :mem 49916, :secs 8.83, :busy 32.43},
  :fannkuch-redux {:gz 1527, :mem 32896, :secs 15.42, :busy 59.85},
  :k-nucleotide {:gz 2479, :mem 542300, :secs 17.05, :busy 61.39},
  :reverse-complement
  {:gz 904, :mem 1403692, :secs 11.89, :busy 12.25},
  :fasta {:gz 1757, :mem 17576, :secs 8.08, :busy 8.18}},
 :typescript
 {:spectral-norm {:gz 388, :mem 33536, :secs 15.83, :busy 16.0},
  :regex-redux {:gz 440, :mem 566992, :secs 11.81, :busy 12.42},
  :n-body {:gz 1354, :mem 34136, :secs 24.63, :busy 24.94},
  :pidigits {},
  :binary-trees {:gz 948, :mem 1060624, :secs 23.23, :busy 75.53},
  :mandelbrot {:gz 1034, :mem 94356, :secs 14.16, :busy 50.74},
  :fannkuch-redux {:gz 495, :mem 30964, :secs 74.99, :busy 75.54},
  :k-nucleotide {},
  :reverse-complement {},
  :fasta {:gz 1229, :mem 36956, :secs 9.1, :busy 9.36}},
 :smalltalk
 {:spectral-norm {:gz 1047, :mem 246008, :secs 34.05, :busy 109.55},
  :regex-redux {},
  :n-body {:gz 1782, :mem 54408, :secs 196.11, :busy 199.25},
  :pidigits {:gz 753, :mem 54968, :secs 15.0, :busy 15.59},
  :binary-trees {:gz 930, :mem 375672, :secs 31.84, :busy 81.59},
  :mandelbrot {:gz 929, :mem 176736, :secs 166.11, :busy 579.56},
  :fannkuch-redux {:gz 916, :mem 54572, :secs 710.27, :busy 720.79},
  :k-nucleotide {:gz 1317, :mem 384920, :secs 658.71, :busy 671.08},
  :reverse-complement {},
  :fasta {:gz 1539, :mem 54640, :secs 48.66, :busy 49.21}},
 :swift
 {:spectral-norm {:gz 601, :mem 8080, :secs 3.96, :busy 15.78},
  :regex-redux {:gz 715, :mem 880268, :secs 41.68, :busy 73.43},
  :n-body {:gz 1355, :mem 13420, :secs 22.03, :busy 22.52},
  :pidigits {:gz 600, :mem 8632, :secs 1.75, :busy 1.77},
  :binary-trees {:gz 714, :mem 733972, :secs 45.22, :busy 135.66},
  :mandelbrot {:gz 1138, :mem 39140, :secs 3.14, :busy 12.45},
  :fannkuch-redux {:gz 1097, :mem 7500, :secs 10.09, :busy 40.15},
  :k-nucleotide {:gz 1367, :mem 257660, :secs 22.11, :busy 83.53},
  :reverse-complement {:gz 1286, :mem 791096, :secs 3.72, :busy 4.58},
  :fasta {:gz 1945, :mem 8464, :secs 3.08, :busy 4.76}},
 :julia
 {:spectral-norm {:gz 370, :mem 174632, :secs 4.81, :busy 17.16},
  :regex-redux {:gz 408, :mem 350944, :secs 5.83, :busy 6.23},
  :n-body {:gz 1541, :mem 180516, :secs 22.34, :busy 23.22},
  :pidigits {:gz 674, :mem 168968, :secs 2.45, :busy 2.79},
  :binary-trees {:gz 372, :mem 634308, :secs 23.88, :busy 78.75},
  :mandelbrot {:gz 713, :mem 224692, :secs 4.5, :busy 12.64},
  :fannkuch-redux {:gz 1067, :mem 192580, :secs 11.36, :busy 42.32},
  :k-nucleotide {:gz 1437, :mem 334520, :secs 14.36, :busy 40.97},
  :reverse-complement {:gz 724, :mem 714064, :secs 4.85, :busy 5.36},
  :fasta {:gz 1049, :mem 215044, :secs 4.93, :busy 5.36}},
 :ada
 {:spectral-norm {:gz 2770, :mem 4320, :secs 2.0, :busy 7.9},
  :regex-redux {:gz 3640, :mem 154328, :secs 6.97, :busy 19.9},
  :n-body {:gz 2617, :mem 1896, :secs 9.04, :busy 9.32},
  :pidigits {:gz 1130, :mem 4580, :secs 1.75, :busy 1.78},
  :binary-trees {:gz 2107, :mem 202248, :secs 9.64, :busy 33.29},
  :mandelbrot {:gz 1819, :mem 35952, :secs 5.59, :busy 22.19},
  :fannkuch-redux {:gz 2113, :mem 4336, :secs 9.89, :busy 39.46},
  :k-nucleotide {:gz 4908, :mem 258468, :secs 11.6, :busy 25.25},
  :reverse-complement {:gz 3283, :mem 793072, :secs 3.87, :busy 4.44},
  :fasta {:gz 2221, :mem 1960, :secs 4.11, :busy 4.2}},
 :java
 {:spectral-norm {:gz 950, :mem 36740, :secs 4.19, :busy 16.36},
  :regex-redux {:gz 740, :mem 645680, :secs 10.48, :busy 31.62},
  :n-body {:gz 1429, :mem 35588, :secs 21.94, :busy 22.39},
  :pidigits {:gz 938, :mem 39680, :secs 3.07, :busy 3.3},
  :binary-trees {:gz 835, :mem 907060, :secs 8.28, :busy 27.59},
  :mandelbrot {:gz 796, :mem 79184, :secs 5.98, :busy 23.43},
  :fannkuch-redux {:gz 1282, :mem 34236, :secs 17.04, :busy 67.3},
  :k-nucleotide {:gz 1812, :mem 446004, :secs 8.7, :busy 27.18},
  :reverse-complement {:gz 2183, :mem 740524, :secs 3.27, :busy 7.44},
  :fasta {:gz 2473, :mem 45156, :secs 2.23, :busy 5.99}},
 :c
 {:spectral-norm {:gz 1139, :mem 1252, :secs 1.98, :busy 7.88},
  :regex-redux {:gz 1397, :mem 152236, :secs 1.46, :busy 3.43},
  :n-body {:gz 1391, :mem 8, :secs 7.49, :busy 7.56},
  :pidigits {:gz 452, :mem 2660, :secs 1.75, :busy 2.02},
  :binary-trees {:gz 809, :mem 168744, :secs 3.48, :busy 11.47},
  :mandelbrot {:gz 1135, :mem 26204, :secs 1.65, :busy 6.56},
  :fannkuch-redux {:gz 910, :mem 880, :secs 8.61, :busy 33.96},
  :k-nucleotide {:gz 1506, :mem 130104, :secs 5.01, :busy 16.41},
  :reverse-complement {:gz 1438, :mem 994532, :secs 1.78, :busy 4.02},
  :fasta {:gz 2268, :mem 2912, :secs 1.36, :busy 5.42}},
 :c++
 {:spectral-norm {:gz 1044, :mem 1268, :secs 1.98, :busy 7.89},
  :regex-redux {:gz 1315, :mem 203760, :secs 1.82, :busy 4.43},
  :n-body {:gz 1773, :mem 1112, :secs 8.18, :busy 8.24},
  :pidigits {:gz 513, :mem 4460, :secs 1.89, :busy 1.97},
  :binary-trees {:gz 809, :mem 117164, :secs 3.79, :busy 12.28},
  :mandelbrot {:gz 1791, :mem 26324, :secs 1.5, :busy 5.97},
  :fannkuch-redux {:gz 980, :mem 1884, :secs 10.08, :busy 39.72},
  :k-nucleotide {:gz 1624, :mem 156180, :secs 3.76, :busy 11.55},
  :reverse-complement {:gz 1226, :mem 996188, :secs 1.55, :busy 2.66},
  :fasta {:gz 2711, :mem 1824, :secs 1.33, :busy 4.31}},
 :f#
 {:spectral-norm {:gz 730, :mem 37496, :secs 4.16, :busy 16.02},
  :regex-redux {:gz 611, :mem 1497456, :secs 14.1, :busy 46.88},
  :n-body {:gz 1381, :mem 39152, :secs 22.94, :busy 23.33},
  :pidigits {:gz 874, :mem 37908, :secs 3.11, :busy 3.18},
  :binary-trees {:gz 631, :mem 1044600, :secs 8.03, :busy 26.86},
  :mandelbrot {:gz 897, :mem 67412, :secs 6.7, :busy 26.27},
  :fannkuch-redux {:gz 924, :mem 37412, :secs 16.75, :busy 65.35},
  :k-nucleotide {:gz 1907, :mem 185148, :secs 5.89, :busy 19.63},
  :reverse-complement {:gz 1140, :mem 1035904, :secs 3.06, :busy 8.52},
  :fasta {:gz 1350, :mem 99404, :secs 1.68, :busy 6.16}},
 :c#
 {:spectral-norm {:gz 878, :mem 36056, :secs 4.11, :busy 15.9},
  :regex-redux {:gz 1869, :mem 295716, :secs 2.24, :busy 4.29},
  :n-body {:gz 1542, :mem 36580, :secs 21.45, :busy 22.28},
  :pidigits {:gz 973, :mem 38208, :secs 2.1, :busy 2.15},
  :binary-trees {:gz 810, :mem 805016, :secs 8.05, :busy 26.8},
  :mandelbrot {:gz 816, :mem 66320, :secs 5.54, :busy 21.63},
  :fannkuch-redux {:gz 1189, :mem 35736, :secs 16.73, :busy 66.42},
  :k-nucleotide {:gz 2574, :mem 186384, :secs 5.68, :busy 18.86},
  :reverse-complement {:gz 1621, :mem 1036072, :secs 3.04, :busy 7.35},
  :fasta {:gz 2098, :mem 67552, :secs 2.28, :busy 8.19}},
 :python
 {:spectral-norm {:gz 443, :mem 51700, :secs 175.91, :busy 699.17},
  :regex-redux {:gz 512, :mem 444704, :secs 17.64, :busy 32.85},
  :n-body {:gz 1196, :mem 7844, :secs 774.34, :busy 781.93},
  :pidigits {:gz 386, :mem 10140, :secs 3.47, :busy 3.52},
  :binary-trees {:gz 589, :mem 451324, :secs 81.03, :busy 288.46},
  :mandelbrot {:gz 688, :mem 52412, :secs 284.36, :busy 1137.0},
  :fannkuch-redux {:gz 950, :mem 49972, :secs 477.0, :busy 1887.27},
  :k-nucleotide {:gz 1967, :mem 188140, :secs 74.12, :busy 280.38},
  :reverse-complement
  {:gz 814, :mem 1007292, :secs 18.59, :busy 24.35},
  :fasta {:gz 1947, :mem 682516, :secs 63.1, :busy 142.96}},
 :php
 {:spectral-norm {:gz 1152, :mem 24140, :secs 33.12, :busy 131.98},
  :regex-redux {:gz 816, :mem 158000, :secs 2.8, :busy 5.48},
  :n-body {:gz 1082, :mem 8032, :secs 312.82, :busy 316.25},
  :pidigits {:gz 399, :mem 9112, :secs 2.16, :busy 2.25},
  :binary-trees {:gz 751, :mem 1584428, :secs 50.51, :busy 182.85},
  :mandelbrot {:gz 875, :mem 127020, :secs 117.2, :busy 468.2},
  :fannkuch-redux {:gz 1160, :mem 21980, :secs 226.26, :busy 901.84},
  :k-nucleotide {:gz 1079, :mem 176076, :secs 41.23, :busy 134.55},
  :reverse-complement {:gz 438, :mem 528064, :secs 13.6, :busy 20.95},
  :fasta {:gz 1062, :mem 8072, :secs 56.53, :busy 57.08}},
 :perl
 {:spectral-norm {:gz 555, :mem 11248, :secs 43.08, :busy 165.57},
  :regex-redux {:gz 820, :mem 155844, :secs 14.95, :busy 44.17},
  :n-body {:gz 1429, :mem 5608, :secs 692.88, :busy 699.64},
  :pidigits {:gz 261, :mem 7780, :secs 3.61, :busy 3.72},
  :binary-trees {:gz 648, :mem 2202756, :secs 175.97, :busy 577.21},
  :mandelbrot {:gz 586, :mem 43280, :secs 663.0, :busy 2651.28},
  :fannkuch-redux {:gz 570, :mem 11148, :secs 571.56, :busy 2235.85},
  :k-nucleotide {:gz 652, :mem 1252960, :secs 58.5, :busy 198.48},
  :reverse-complement
  {:gz 287, :mem 1494344, :secs 10.31, :busy 10.42},
  :fasta {:gz 871, :mem 54540, :secs 86.24, :busy 87.11}},
 :rust
 {:spectral-norm {:gz 1126, :mem 2312, :secs 1.97, :busy 7.87},
  :regex-redux {:gz 986, :mem 153232, :secs 2.16, :busy 3.17},
  :n-body {:gz 1753, :mem 872, :secs 5.71, :busy 5.79},
  :pidigits {:gz 1366, :mem 3172, :secs 1.75, :busy 1.8},
  :binary-trees {:gz 756, :mem 152504, :secs 3.26, :busy 11.97},
  :mandelbrot {:gz 719, :mem 32092, :secs 1.98, :busy 7.83},
  :fannkuch-redux {:gz 1020, :mem 872, :secs 10.29, :busy 40.17},
  :k-nucleotide {:gz 1841, :mem 134280, :secs 5.33, :busy 16.09},
  :reverse-complement {:gz 1376, :mem 994780, :secs 1.63, :busy 2.8},
  :fasta {:gz 1906, :mem 2036, :secs 1.47, :busy 4.6}},
 :erlang
 {:spectral-norm {:gz 747, :mem 30656, :secs 15.65, :busy 61.72},
  :regex-redux {:gz 1048, :mem 3325836, :secs 38.15, :busy 67.1},
  :n-body {:gz 1399, :mem 22960, :secs 195.59, :busy 197.84},
  :pidigits {:gz 562, :mem 47588, :secs 13.82, :busy 16.92},
  :binary-trees {:gz 478, :mem 454164, :secs 8.03, :busy 23.79},
  :mandelbrot {:gz 806, :mem 50308, :secs 110.56, :busy 441.87},
  :fannkuch-redux {:gz 1038, :mem 23632, :secs 91.12, :busy 358.61},
  :k-nucleotide {:gz 937, :mem 718388, :secs 122.06, :busy 362.22},
  :reverse-complement
  {:gz 1302, :mem 2152912, :secs 60.67, :busy 145.4},
  :fasta {:gz 1164, :mem 24844, :secs 32.62, :busy 36.31}},
 :racket
 {:spectral-norm {:gz 627, :mem 48148, :secs 5.67, :busy 20.94},
  :regex-redux {:gz 729, :mem 1249264, :secs 26.48, :busy 57.98},
  :n-body {:gz 1689, :mem 54040, :secs 53.97, :busy 55.05},
  :pidigits {:gz 1136, :mem 49620, :secs 2.59, :busy 2.64},
  :binary-trees {:gz 853, :mem 1091760, :secs 19.37, :busy 63.19},
  :mandelbrot {:gz 801, :mem 135252, :secs 19.89, :busy 75.02},
  :fannkuch-redux {:gz 1101, :mem 46588, :secs 101.66, :busy 399.88},
  :k-nucleotide {:gz 885, :mem 396808, :secs 94.05, :busy 95.02},
  :reverse-complement
  {:gz 1030, :mem 654488, :secs 17.52, :busy 17.73},
  :fasta {:gz 1280, :mem 49124, :secs 17.7, :busy 36.02}},
 :ruby
 {:spectral-norm {:gz 326, :mem 18324, :secs 232.89, :busy 274.11},
  :regex-redux {:gz 751, :mem 268116, :secs 21.68, :busy 68.01},
  :n-body {:gz 1137, :mem 15760, :secs 382.36, :busy 429.0},
  :pidigits {:gz 485, :mem 328844, :secs 3.22, :busy 7.5},
  :binary-trees {:gz 1107, :mem 413136, :secs 64.75, :busy 221.94},
  :mandelbrot {:gz 954, :mem 59864, :secs 444.18, :busy 1774.22},
  :fannkuch-redux {:gz 1454, :mem 14492, :secs 558.13, :busy 2138.85},
  :k-nucleotide {:gz 667, :mem 137772, :secs 180.88, :busy 681.89},
  :reverse-complement
  {:gz 295, :mem 1605020, :secs 24.62, :busy 45.49},
  :fasta {:gz 1069, :mem 97260, :secs 66.96, :busy 106.91}},
 :fortran
 {:spectral-norm {:gz 638, :mem 1732, :secs 1.98, :busy 7.92},
  :regex-redux {},
  :n-body {:gz 1524, :mem 8, :secs 8.28, :busy 8.36},
  :pidigits {:gz 981, :mem 3964, :secs 1.74, :busy 1.8},
  :binary-trees {:gz 1148, :mem 113000, :secs 5.45, :busy 16.07},
  :mandelbrot {:gz 661, :mem 61836, :secs 6.7, :busy 23.22},
  :fannkuch-redux {:gz 1158, :mem 11040, :secs 12.37, :busy 49.4},
  :k-nucleotide {:gz 2238, :mem 203268, :secs 97.53, :busy 98.35},
  :reverse-complement {:gz 1019, :mem 985344, :secs 4.83, :busy 4.87},
  :fasta {:gz 1351, :mem 8, :secs 3.34, :busy 3.65}},
 :ocaml
 {:spectral-norm {:gz 377, :mem 3716, :secs 15.7, :busy 16.03},
  :regex-redux {:gz 637, :mem 969076, :secs 24.81, :busy 25.15},
  :n-body {:gz 1251, :mem 1496, :secs 21.69, :busy 22.18},
  :pidigits {:gz 458, :mem 20004, :secs 6.74, :busy 6.96},
  :binary-trees {:gz 751, :mem 152708, :secs 10.01, :busy 29.55},
  :mandelbrot {:gz 717, :mem 4916, :secs 13.75, :busy 54.88},
  :fannkuch-redux {:gz 1017, :mem 28692, :secs 16.33, :busy 65.22},
  :k-nucleotide {:gz 1833, :mem 255584, :secs 22.37, :busy 62.55},
  :reverse-complement {:gz 1368, :mem 34116, :secs 3.71, :busy 8.66},
  :fasta {:gz 1189, :mem 197120, :secs 6.08, :busy 6.17}},
 :dart
 {:spectral-norm {:gz 489, :mem 132012, :secs 16.06, :busy 16.75},
  :regex-redux {:gz 1041, :mem 916268, :secs 8.33, :busy 13.6},
  :n-body {:gz 1409, :mem 126116, :secs 28.2, :busy 28.99},
  :pidigits {:gz 500, :mem 128372, :secs 11.29, :busy 11.91},
  :binary-trees {:gz 1410, :mem 935556, :secs 16.27, :busy 44.56},
  :mandelbrot {:gz 911, :mem 176852, :secs 21.04, :busy 57.43},
  :fannkuch-redux {:gz 495, :mem 130492, :secs 97.09, :busy 98.18},
  :k-nucleotide {:gz 1502, :mem 461700, :secs 35.5, :busy 93.65},
  :reverse-complement {},
  :fasta {:gz 1403, :mem 128924, :secs 8.63, :busy 9.28}}}

```
