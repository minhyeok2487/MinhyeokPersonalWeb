var columns = new Array();
var content_table = new Array();
$("#content_table tbody th").each(function(index, element) {
    columns.push(element.innerText);
});
$("#content_table [name=get_1]").each(function(index, element) {
    content_table.push(element.innerText);
});
new Chart(document.getElementById("chaos-line-chart"), {
    type: 'line',
    data: {
        labels: columns,
        datasets: [{
            data: content_table,
            label: "1수 거래가능 재화",
            borderColor: "#3e95cd",
            fill: false
        }]
    },
    options: {
        title: {
            display: true,
            text: '일일 컨텐츠 수익'
        }
    }
});
