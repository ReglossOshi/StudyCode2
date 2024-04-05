<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 차트.js 라이브러리 -->
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script defer type="text/javascript" src="js/chart.js"></script>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/index.css">
<link rel="icon" href="image/icons.png">
<link >
<title>의류 생산 관리 시스템</title>
</head>
<body>
<%@ include file="header.jsp" %>
	<script>
		import Chart from 'chart.js/auto';
		import { getRelativePosition } from 'chart.js/helpers';
	</script>
	
	<div class="main">
		<div class="banner"><div>공사중</div></div>
		<div class="chart">
	  		<canvas id="myChart" width="400" height="400"></canvas>
	  		<canvas id="circleChart" width="400" height="400"></canvas>
		</div>
	</div>


<script>
  const ctx = document.getElementById('myChart');

  new Chart(ctx, {
    type: 'line',
    data: {
      labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
      datasets: [{
        label: '# of Votes',
        data: [12, 19, 3, 5, 2, 3],
        borderWidth: 1
      }]
    },
    options: {
    	animations: {
    	      tension: {
    	        duration: 1000,
    	        easing: 'linear',
    	        from: 1,
    	        to: 0,
    	        loop: true
    	      }
    	    },
    	responsive:false,
      scales: {
        y: {
          beginAtZero: true
        }
      }
    }
  });
  
  const ctx2 = document.getElementById('circleChart');

  new Chart(ctx2, {
    type: 'doughnut',
    data: {
      labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
      datasets: [{
        label: '# of Votes',
        data: [12, 19, 3, 5, 2, 3],
        borderWidth: 1
      }]
    },
    options: {
    	animations: {
    	      tension: {
    	        duration: 1000,
    	        easing: 'linear',
    	        from: 1,
    	        to: 0,
    	        loop: true
    	      }
    	    },
    	responsive:false,
      scales: {
        y: {
          beginAtZero: true
        }
      }
    }
  });
</script>
</body>
</html>