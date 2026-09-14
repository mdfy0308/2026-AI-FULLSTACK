import pandas as pd
from django.shortcuts import render
from .models import ServiceLog

def dashboard_view(request):
    qs = ServiceLog.objects.all().values('date', 'category', 'visitor_count', 'sales_amount')

    # 1. DB 전체 데이터를 QuerySet으로 추출 후 Pandas DataFrame으로 변환
    if qs.exists():
        df = pd.DataFrame(list(qs))

        # 2. Pandas 연산: 카테고리별 방문자 수 및 매출액 합계 집계
        #34495e       1) 그룹핑     합계      재정렬
        summary_df = df.groupby('category')[['visitor_count', 'sales_amount']].sum().reset_index()

        # 3. 템플릿 전달용 순수 파이썬 리스트 추출
        categories = summary_df['category'].tolist()
        visitors = summary_df['visitor_count'].tolist()
        sales  = summary_df['sales_amount'].tolist()
    else:
        categories, visitors, sales = [], [], []
    #4. 템플릿(html) 전달할 때 바인딩 객체(Spring - Model, ModelAndView)
    context = {
        'categories': categories,
        'visitors': visitors,
        'sales': sales,
    }
    return render(request, 'dashboard.html', context)