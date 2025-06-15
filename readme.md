# Java 7 Performance Testing

## Results

### short[10000][10000] array sum with unrolled loops

With short being 2 bytes and each cache line being 64 bytes, we expect the 32 to be the best version. 24 seems just as
good though

| Benchmark                               | Mode | Cnt |          Score |       Error | Units |
|:----------------------------------------|:-----|----:|---------------:|------------:|:------|
| Short2DArraySum.sum_i_j                 | avgt |  75 |   98703470,265 | 1448076,052 | ns/op |
| Short2DArraySum.sum_i_j_unrolled_02     | avgt |  75 |   84268643,936 |  639191,189 | ns/op |
| Short2DArraySum.sum_i_j_unrolled_04     | avgt |  75 |   78784475,701 |  765957,676 | ns/op |
| Short2DArraySum.sum_i_j_unrolled_06     | avgt |  75 |   74445694,121 |  868277,169 | ns/op |
| Short2DArraySum.sum_i_j_unrolled_08     | avgt |  75 |   72824565,633 |  432336,431 | ns/op |
| Short2DArraySum.sum_i_j_unrolled_16     | avgt |  75 |   66186181,185 |  524922,407 | ns/op |
| **Short2DArraySum.sum_i_j_unrolled_24** | avgt |  75 |   62618147,548 |  360700,431 | ns/op |
| **Short2DArraySum.sum_i_j_unrolled_32** | avgt |  75 |   63825831,212 |  418283,949 | ns/op |
| Short2DArraySum.sum_i_j_unrolled_48     | avgt |  75 |   64414180,641 |  343227,529 | ns/op |
| Short2DArraySum.sum_i_j_unrolled_64     | avgt |  75 |   63978409,385 |  341619,693 | ns/op |
| Short2DArraySum.sum_j_i                 | avgt |  75 | 1007838327,960 | 3473164,716 | ns/op |

### int[5000][5000] array sum with unrolled loops

| Benchmark                             | Mode | Cnt |         Score |      Error | Units |
|:--------------------------------------|:-----|----:|--------------:|-----------:|:------|
| Int2DArraySum.sum_i_j                 | avgt |  75 |  25181103,653 | 822938,683 | ns/op |
| Int2DArraySum.sum_i_j_unrolled_02     | avgt |  75 |  22126588,429 | 313788,243 | ns/op |
| Int2DArraySum.sum_i_j_unrolled_04     | avgt |  75 |  19274305,636 | 113427,779 | ns/op |
| Int2DArraySum.sum_i_j_unrolled_06     | avgt |  75 |  18143562,732 | 103678,332 | ns/op |
| **Int2DArraySum.sum_i_j_unrolled_08** | avgt |  75 |  16812119,886 | 338857,163 | ns/op |
| Int2DArraySum.sum_i_j_unrolled_16     | avgt |  75 |  16520969,186 |  62259,978 | ns/op |
| Int2DArraySum.sum_i_j_unrolled_24     | avgt |  75 |  15230212,586 | 160667,239 | ns/op |
| Int2DArraySum.sum_i_j_unrolled_32     | avgt |  75 |  15289729,959 |  95859,488 | ns/op |
| Int2DArraySum.sum_i_j_unrolled_48     | avgt |  75 |  15838240,709 | 116473,932 | ns/op |
| Int2DArraySum.sum_i_j_unrolled_64     | avgt |  75 |  15790014,411 | 113931,216 | ns/op |
| Int2DArraySum.sum_j_i                 | avgt |  75 | 243424654,222 | 668994,130 | ns/op |

### Parsing web-service xml (for specific project)

| Benchmark                                      | Mode | Cnt |      Score |    Error | Units |
|:-----------------------------------------------|:-----|----:|-----------:|---------:|:------|
| SetDebtRegexMethod.setDebtRegexParsing         | avgt |  30 | 479132,600 | 3400,305 | ns/op |
| **SetDebtStringMethod.setDebtStringParsing**   | avgt |  30 | 106157,421 | 2538,565 | ns/op |
| SetDebtCharArrayMethod.setDebtCharArrayParsing | avgt |  30 | 993469,015 | 2538,565 | ns/op |
