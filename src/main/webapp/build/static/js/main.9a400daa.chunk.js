(window.webpackJsonp=window.webpackJsonp||[]).push([[0],{245:function(e,t,a){"use strict";a.r(t);var n=a(0),c=a.n(n),o=a(81),l=a(20),r=a(7),s=a(8),i=a(10),u=a(9),d=a(11),m=a(246),p=(c.a.Component,a(1)),h=a.n(p),_=a(24),b=a.n(_),v=a(49),k=a(84),y=a.n(k)()({HOME:null,HOMESUB:null}),f=a(35),E=a.n(f),x=y.HOME,g=y.HOMESUB;function j(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:"";return function(){var t=Object(v.a)(b.a.mark(function t(a){var n;return b.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:return t.prev=0,t.next=3,E.a.get("/dklxxt/getPro.do".concat(e));case 3:n=t.sent.data,a({type:x,data:n}),t.next=9;break;case 7:t.prev=7,t.t0=t.catch(0);case 9:case"end":return t.stop()}},t,this,[[0,7]])}));return function(e){return t.apply(this,arguments)}}()}var w=a(19),O=a.n(w),A=a(85),C=a.n(A),B=function(e){function t(){return Object(r.a)(this,t),Object(i.a)(this,Object(u.a)(t).call(this))}return Object(d.a)(t,e),Object(s.a)(t,[{key:"componentDidMount",value:function(){this.props.dispatch(j())}},{key:"render",value:function(){return c.a.createElement("div",null,c.a.createElement("div",{styleName:"start"},c.a.createElement("div",{styleName:"go"},c.a.createElement(m.a,{styleName:"link",to:"/problem"},"\xa0\u5f00 \u59cb \u7b54 \u9898\xa0")),c.a.createElement("div",{styleName:"show"},c.a.createElement("p",null,"\u6d4b\u8bd5\u65f6\u95f4\uff1a30\u5206\u949f"),c.a.createElement("p",null,"\u9898\u76ee\u6570\u91cf\uff1a40\u9898"),c.a.createElement("p",null,"\u9898\u76ee\u7c7b\u578b\uff1a\u591a\u9009\u9898 \u5355\u9009\u9898 \u5224\u65ad\u9898"),c.a.createElement("p",null,"\u70b9\u51fb\u4e0a\u65b9\u2018\u5f00\u59cb\u7b54\u9898\u2019\u8fdb\u5165\u8003\u8bd5\u9875\u9762\u5e76\u5f00\u59cb\u8ba1\u65f6"))))}}]),t}(c.a.Component);B.contextTypes={route:h.a.object,location:h.a.object};var N=O()(B,C.a),S=Object(l.b)(function(e){return{todos:e.todos}})(N),D=a(249),H=a(248),P=a(21),F=a(18),M=a(86),V=a.n(M),T=function(e){function t(){var e;return Object(r.a)(this,t),(e=Object(i.a)(this,Object(u.a)(t).call(this))).init=function(){for(var t=e.state.detalis,a=0;a<40;a++){var n={index:a+1,type:""};t[a]=n}e.mounted&&e.setState({detalis:t})},e.front=function(){var t=e.state.index;0!=t?(t--,e.setstati(t),e.setState({index:t,anws:[]})):alert("\u8fd9\u662f\u7b2c\u4e00\u9898\uff01")},e.setstati=function(t){var a=e.props.home.data.data,n="",c="";n=a[t].yuoeAn,c=a[t].ans,3==a[t].type&&("A"==c?c="\u5bf9":"B"==c&&(c="\u9519"),"A"==n?n="\u5bf9":"B"==n&&(n="\u9519")),c?e.setState({disabled:!0}):(n="",e.setState({disabled:!1})),e.setState({index:t,yuoeAn:n,ans:c,textValues:"",anws:[],checkedA:!1,checkedB:!1,checkedC:!1,checkedD:!1,checkedE:!1,checkedF:!1,textValue:"\u6bcf\u4e2a\u5c0f\u70b9\u7528,\u9694\u5f00 \u6bcf\u4e2a\u7a7a\u7528\u3001\u9694\u5f00!!"})},e.next=function(){var t=e.state.index;39!=t?(t++,e.setstati(t)):alert("\u8fd9\u662f\u6700\u540e\u4e00\u9898\uff01")},e.changeIndex=function(t){e.setState({index:t,anws:[]}),e.setstati(t)},e.handchange=function(t){e.state.anws;var a=e.props.home.data.data,n=(a[e.state.index].type,t.target.value);a[e.state.index].yuoeAn=n,e.setState({completion:t.target.value,textValues:n})},e.re=function(){e.props.history.push("/")},e.subm=function(){var t=e.props.home.data.data,a=e.state,n=a.index,c=a.detalis,o=(t=t[n]).yuoeAn;t.type;3==t.type?"A"==o?e.setState({yuoeAn:"\u5bf9"}):"B"==o&&e.setState({yuoeAn:"\u9519"}):e.setState({yuoeAn:o}),""!=o?(e.setState({disabled:!0}),e.props.dispatch(function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:"";return function(){var t=Object(v.a)(b.a.mark(function t(a){var n;return b.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:return t.prev=0,t.next=3,E.a.get("/dklxxt/judge.do?".concat(e));case 3:n=t.sent.data,a({type:g,data:n}),t.next=9;break;case 7:t.prev=7,t.t0=t.catch(0);case 9:case"end":return t.stop()}},t,this,[[0,7]])}));return function(e){return t.apply(this,arguments)}}()}("id=".concat(t.id,"&ans=").concat(o))).then(function(){var a=e.props.home.sub.data,o=a.status,l=a.ans,r=o;c[n].type=o;var s=e.state.rightNum;1==r&&s++,e.props.home.data.data[n]=Object(F.a)({},e.props.home.data.data[n],{ans:l}),3==t.type&&("A"==l?l="\u5bf9":"B"==l&&(l="\u9519")),e.setState({ans:l,rightNum:s})})):alert("\u8bf7\u9009\u62e9\u4f60\u7684\u7b54\u6848\uff01\uff01")},e.submm=function(){e.state.rightNum;e.setState({display:"block",display2:"none"})},e.check=function(t){if((t=t||window.event).target&&"<"!==Object(P.a)(t.target.innerHTML)[0]){var a,n,c,o;a=t.target.value?t.target.value:t.target.innerHTML,n=Object(P.a)(a)[0];var l=e.state.anws,r="",s=e.props.home.data.data,i=s[e.state.index].type;if(2!=i)switch(c="\u5bf9"==n?"A":"\u9519"==n?"B":n,3==i?(l[0]=t.target.value||c,o=c):(l[0]=t.target.value||n,o=n),o){case"A":e.setState({checkedA:!0,checkedB:!1,checkedC:!1,checkedD:!1});break;case"B":e.setState({checkedA:!1,checkedB:!0,checkedC:!1,checkedD:!1});break;case"C":e.setState({checkedA:!1,checkedB:!1,checkedC:!0,checkedD:!1});break;case"D":e.setState({checkedA:!1,checkedB:!1,checkedC:!1,checkedD:!0})}else if(2==i){var u=l.indexOf(t.target.value||n);-1==u?l.push(n):l.splice(u,1);for(var d=!1,m=!1,p=!1,h=!1,_=!1,b=!1,v=0;v<l.length;v++){switch(l[v]){case"A":d=!0;break;case"B":m=!0;break;case"C":p=!0;break;case"D":h=!0;break;case"E":_=!0;break;case"F":b=!0}}e.setState({checkedA:d,checkedB:m,checkedC:p,checkedD:h,checkedE:_,checkedF:b})}(l=Object(P.a)(new Set(l))).sort();var k=!0,y=!1,f=void 0;try{for(var E,x=l[Symbol.iterator]();!(k=(E=x.next()).done);k=!0){r+=E.value}}catch(g){y=!0,f=g}finally{try{k||null==x.return||x.return()}finally{if(y)throw f}}s[e.state.index].yuoeAn=r,e.setState({anws:l})}},e.chan=function(e){(e=e||window.event).target.checked=!0},e.mounted=!1,e.state={select:[{option:"\u6839\u672c",name:"A",value:"A"},{option:"\u57fa\u672c",name:"A",value:"B"}],index:0,detalis:[],anws:[],yuoeAn:"",ans:"",time:29,s:60,rightNum:0,disabled:!1,completion:"",selects1:[],color:"red",display:"none",display2:"",checkedA:!1,checkedB:!1,checkedC:!1,checkedD:!1,checkedE:!1,checkedF:!1,textValue:"\u6bcf\u4e2a\u5c0f\u70b9\u7528,\u9694\u5f00 \u6bcf\u4e2a\u7a7a\u7528\u3001\u9694\u5f00!!",textValues:""},e}return Object(d.a)(t,e),Object(s.a)(t,[{key:"componentWillMount",value:function(){var e=this,t=setInterval(function(){var a=e.state,n=a.time,c=(a.rightNum,a.s);0==--c&&(n--,c=59),e.mounted&&e.setState({s:c,time:n}),0===n&&(clearInterval(t),e.setState({display:"block",display2:"none"}))},1e3);this.mounted=!0}},{key:"componentWillUnmount",value:function(){this.mounted=!0}},{key:"componentDidMount",value:function(){var e=this;this.init(),this.props.dispatch(j()).then(function(){var t=[];e.props.home&&(t=e.props.home.data.data);for(var a=0;a<t.length;a++)t[a]=Object(F.a)({},t[a],{yuoeAn:""}),t[a]=Object(F.a)({},t[a],{ans:""})})}},{key:"render",value:function(){var e=this,t={display:this.state.display},a={display:this.state.display2};return c.a.createElement("div",null,c.a.createElement("div",{styleName:"tier",ref:function(t){e.tire=t},style:t},c.a.createElement("h3",null,"\u7528\u65f6",30-this.state.time,"\u5206\u949f"),c.a.createElement("p",null,c.a.createElement("span",null,"\u7b54\u5bf9\uff1a",this.state.rightNum)),c.a.createElement("p",null,c.a.createElement("span",null,"\u6b63\u786e\u7387\uff1a",parseFloat(this.state.rightNum/40*100),"%")),c.a.createElement("p",null,c.a.createElement("input",{type:"button",value:"\u91cd\u65b0\u5f00\u59cb",onClick:this.re}))),c.a.createElement("div",{styleName:"box",style:a},c.a.createElement("div",{styleName:"wrapper"},c.a.createElement("fieldset",{styleName:"marf"},c.a.createElement("legend",null,c.a.createElement("b",null,"\u5012\u8ba1\u65f6")),c.a.createElement("div",{id:"Viewtime"},this.state.time,"\uff1a",this.state.s)),c.a.createElement("fieldset",{styleName:"marf"},c.a.createElement("legend",null,c.a.createElement("b",null,"\u6b63\u786e\u9898\u6570")),c.a.createElement("div",{id:"scores"},this.state.rightNum))),c.a.createElement("div",{styleName:"problem_content"},c.a.createElement("fieldset",{styleName:"problem_wrapper"},c.a.createElement("legend",null,c.a.createElement("b",null,"\u8003\u8bd5\u9898\u76ee")),c.a.createElement("div",{styleName:"title"},function(){var t=e.state.index,a=e.props.home.data;if(e.props.home.data){var n=a=a.data[t],o=n.content;if(n.type)return c.a.createElement("h4",null,"\u7b2c",t+1,"\u9898\uff1a",o)}}()),c.a.createElement("div",{styleName:"checks"},function(){var t=e.state.index;if(e.props.home){var a=e.props.home.data;if(e.props.home.data){var n=(a=a.data[t]).type,o=a,l=o.op1,r=o.op2,s=o.op3,i=o.op4,u=o.op5,d=o.op6,m=[];if(1==n){m.push({name:"1",value:"".concat(l),option:"A",checked:e.state.checkedA},{name:"1",value:"".concat(r),option:"B",checked:e.state.checkedB},{name:"1",value:"".concat(s),option:"C",checked:e.state.checkedC},{name:"1",value:"".concat(i),option:"D",checked:e.state.checkedD});var p=m.map(function(t,a){if(e)return c.a.createElement("div",{onClick:e.check,value:t.option,key:t.value},c.a.createElement("input",{type:"radio",name:t.name,value:t.option,checked:t.checked,onChange:e.chan}),c.a.createElement("label",{name:t.name,onClick:e.check},t.option,":",t.value))});return c.a.createElement("div",{onClick:e.check},p)}return 2==n?(m.push({name:"1",value:"".concat(l),option:"A",checked:e.state.checkedA},{name:"1",value:"".concat(r),option:"B",checked:e.state.checkedB},{name:"1",value:"".concat(s),option:"C",checked:e.state.checkedC},{name:"1",value:"".concat(i),option:"D",checked:e.state.checkedD}),null!=u&&(m=Object(P.a)(m).concat([{name:"1",value:"".concat(u),option:"E",checked:e.state.checkedE}])),null!=d&&(m=Object(P.a)(m).concat([{name:"1",value:"".concat(d),option:"F",checked:e.state.checkedF}])),m.map(function(t,a){return c.a.createElement("div",{key:t.value,onClick:e.check},c.a.createElement("input",{type:"checkbox",name:t.option,value:t.option,checked:t.checked,onChange:e.chan}),c.a.createElement("label",null,t.option,":",t.value))})):3==n?(m.push({name:"1",value:"\u5bf9",option:"A",checked:e.state.checkedA},{name:"1",value:"\u9519",option:"B",checked:e.state.checkedB}),m.map(function(t,a){return c.a.createElement("div",{onClick:e.check,key:t.value},c.a.createElement("input",{type:"radio",name:t.name,value:t.option,checked:t.checked,onChange:e.chan}),c.a.createElement("label",null,t.value))})):(m=[],c.a.createElement("div",null,c.a.createElement("textarea",{rows:"3",cols:"40",style:{marginTop:"20px",width:"250px"},placeholder:e.state.textValue,onChange:e.handchange,value:e.state.textValues})))}}}()),c.a.createElement("div",{styleName:"problem_botton"},c.a.createElement("span",null,"\u4f60\u7684\u7b54\u6848\uff1a",this.state.yuoeAn),"\xa0\xa0\xa0\xa0",c.a.createElement("span",null,"\u6b63\u786e\u7b54\u6848\uff1a",this.state.ans),"\xa0\xa0\xa0\xa0",c.a.createElement("div",{styleName:"bott"},c.a.createElement("input",{type:"button",value:"\u4e0a\u4e00\u9898",onClick:this.front}),c.a.createElement("input",{type:"button",value:"\u63d0\u4ea4",onClick:this.subm,disabled:this.state.disabled}),c.a.createElement("input",{type:"button",value:"\u4e0b\u4e00\u9898",onClick:this.next}),c.a.createElement("input",{type:"button",value:"\u5b8c\u6210",onClick:this.submm})))))),c.a.createElement("div",{styleName:"bottom",style:a},c.a.createElement("fieldset",null,c.a.createElement("legend",null,c.a.createElement("b",null,"\u7b54\u9898\u4fe1\u606f")),c.a.createElement("ul",{styleName:"exam_ul"},e.state.detalis.map(function(t,a){var n,o=t.type;return-1==o?n="red":1==o&&(n="#4DB870"),c.a.createElement("li",{style:{background:"".concat(n)},onClick:e.changeIndex.bind(e,a),key:t.index,value:a},c.a.createElement("span",{styleName:"lit"},t.index))})))))}}]),t}(c.a.Component);T.contextTypes={route:h.a.object,location:h.a.object};var I=O()(T,V.a),L=Object(l.b)(function(e){return{home:e.home}})(I),U=function(e){function t(e){return Object(r.a)(this,t),Object(i.a)(this,Object(u.a)(t).call(this,e))}return Object(d.a)(t,e),Object(s.a)(t,[{key:"render",value:function(){return c.a.createElement("main",null,c.a.createElement(D.a,null,c.a.createElement(H.a,{exact:!0,path:"/",component:S}),c.a.createElement(H.a,{exact:!0,path:"/problem",component:L})))}}]),t}(c.a.Component),J=a(88),X=a.n(J),z=function(e){function t(e){return Object(r.a)(this,t),Object(i.a)(this,Object(u.a)(t).call(this,e))}return Object(d.a)(t,e),Object(s.a)(t,[{key:"getChildContext",value:function(){return{location:this.props.location,route:this.props.route}}},{key:"render",value:function(){return c.a.createElement("div",{styleName:"wrapper"},c.a.createElement(U,null))}}]),t}(c.a.Component);z.childContextTypes={location:h.a.object,route:h.a.object},z.contextTypes={location:h.a.object,router:h.a.object};var G=O()(z,X.a),W=a(247),Z=a(89),q=a(17),K=y.HOME,Q=y.HOMESUB,Y=function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:[],t=arguments.length>1?arguments[1]:void 0;switch(t.type){case K:return Object(F.a)({},e,{data:t.data});case Q:return Object(F.a)({},e,{sub:t.data});default:return e}},R=Object(q.c)({home:Y});var $,ee=Object(q.d)(R,$,Object(q.a)(Z.a));Object(o.render)(c.a.createElement(l.a,{store:ee},c.a.createElement(W.a,{store:ee},c.a.createElement(G,null))),document.getElementById("root"))},85:function(e,t,a){e.exports={start:"src-moudles-Home-___Home__start___3LxV_",go:"src-moudles-Home-___Home__go___aZFiX",link:"src-moudles-Home-___Home__link___1665c",show:"src-moudles-Home-___Home__show___1QXsJ"}},86:function(e,t,a){e.exports={box:"src-moudles-Problem-___styles__box___HFaid",wrapper:"src-moudles-Problem-___styles__wrapper___3wBjs",marf:"src-moudles-Problem-___styles__marf___3FPHG",problem_content:"src-moudles-Problem-___styles__problem_content___naAiN",problem_wrapper:"src-moudles-Problem-___styles__problem_wrapper___b6_Ii",title:"src-moudles-Problem-___styles__title___1LaeA",checks:"src-moudles-Problem-___styles__checks___1XVgL",problem_botton:"src-moudles-Problem-___styles__problem_botton___3ZpDY",bott:"src-moudles-Problem-___styles__bott___2AqDU",bottom:"src-moudles-Problem-___styles__bottom___1Im2K",exam_ul:"src-moudles-Problem-___styles__exam_ul___2j0B2",lit:"src-moudles-Problem-___styles__lit___202T5",tier:"src-moudles-Problem-___styles__tier___2GnF9"}},88:function(e,t,a){e.exports={wrapper:"src-components-___styles__wrapper___2j55F"}},90:function(e,t,a){e.exports=a(245)}},[[90,2,1]]]);
//# sourceMappingURL=main.9a400daa.chunk.js.map