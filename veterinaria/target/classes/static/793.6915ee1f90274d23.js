"use strict";(self.webpackChunkfury=self.webpackChunkfury||[]).push([[793],{58793:(Q,d,a)=>{a.r(d),a.d(d,{EstanteModule:()=>K});var m=a(60177),h=a(18498),s=a(9159),C=a(17114),t=a(17705),v=a(97405),g=a(34006),D=a(74061),x=a(75063),u=a(88834),E=a(82765),b=a(99213),p=a(59115),y=a(96695),f=a(2042),j=a(43655),F=a(53007),R=a(15551);function $(n,r){1&n&&(t.j41(0,"th",15)(1,"mat-checkbox",16),t.bIt("click",function(o){return o.stopPropagation()}),t.k0s()())}function T(n,r){1&n&&(t.j41(0,"td",17)(1,"mat-checkbox",16),t.bIt("click",function(o){return o.stopPropagation()}),t.k0s()())}function S(n,r){if(1&n&&(t.j41(0,"th",22),t.EFF(1),t.k0s()),2&n){const e=t.XpG(2).$implicit;t.R7$(1),t.SpI(" ",e.name,"")}}function k(n,r){if(1&n&&(t.j41(0,"td",23),t.EFF(1),t.k0s()),2&n){const e=r.$implicit,o=t.XpG(2).$implicit;t.R7$(1),t.SpI(" ",e[o.property]," ")}}function G(n,r){if(1&n&&(t.qex(0,19),t.DNE(1,S,2,1,"th",20),t.DNE(2,k,2,1,"td",21),t.bVm()),2&n){const e=t.XpG().$implicit;t.Y8G("matColumnDef",e.property)}}function M(n,r){if(1&n&&(t.qex(0),t.DNE(1,G,3,1,"ng-container",18),t.bVm()),2&n){const e=r.$implicit;t.R7$(1),t.Y8G("ngIf",e.isModelProperty)}}function I(n,r){1&n&&t.nrm(0,"th",24)}function N(n,r){if(1&n){const e=t.RV6();t.j41(0,"td",17)(1,"button",25),t.bIt("click",function(i){return i.stopPropagation()}),t.j41(2,"mat-icon"),t.EFF(3,"more_horiz"),t.k0s()(),t.j41(4,"mat-menu",26,27)(6,"button",28),t.bIt("click",function(){const c=t.eBV(e).$implicit,l=t.XpG();return t.Njj(l.updateEstante(c))}),t.j41(7,"span"),t.EFF(8,"Modify"),t.k0s()(),t.j41(9,"button",28),t.bIt("click",function(){const c=t.eBV(e).$implicit,l=t.XpG();return t.Njj(l.deleteEstante(c))}),t.j41(10,"span"),t.EFF(11,"Delete"),t.k0s()()()()}if(2&n){const e=t.sdS(5);t.R7$(1),t.Y8G("matMenuTriggerFor",e)}}function Y(n,r){1&n&&t.nrm(0,"tr",29)}function V(n,r){if(1&n){const e=t.RV6();t.j41(0,"tr",30),t.bIt("click",function(){const c=t.eBV(e).$implicit,l=t.XpG();return t.Njj(l.updateEstante(c))}),t.k0s()}}const _=function(){return["Estantes"]},X=function(){return[]},P=[{path:"",component:(()=>{class n{ngOnInit(){this.getEstantes()}get visibleColumns(){return this.columns.filter(e=>e.visible).map(e=>e.property)}constructor(e,o){this.apiClient=e,this.dialog=o,this.dataSource=new s.I6([]),this.columns=[{name:"ID",property:"id",visible:!0,isModelProperty:!0},{name:"Nombre",property:"nombre",visible:!0,isModelProperty:!0},{name:"Descripcion",property:"descripcion",visible:!0,isModelProperty:!0},{name:"Actions",property:"actions",visible:!0}],this.pageSize=10}getEstantes(){this.apiClient.getRequest("/api/estante").subscribe({next:e=>{this.dataSource.data=e,console.log(e)},error:e=>{console.error(e)}})}createEstante(){console.info("Abre dialogo de creacion"),this.dialog.open(C.X,{width:"400px"}).afterClosed().subscribe(e=>{e?(console.info("Al cerrar",e),this.apiClient.postRequest("/api/estante",e).subscribe({next:o=>{console.info("OK",o),this.getEstantes()},error:o=>{console.error("error",o)}}),console.info("Fin api call")):console.info("Cancelado"),console.info("Fin Metodo")})}updateEstante(e){console.info(e),this.dialog.open(C.X,{data:e,width:"400px"}).afterClosed().subscribe(o=>{o?this.apiClient.putRequest("/api/estante",o.id,o).subscribe({next:i=>{this.getEstantes()},error:i=>{console.info(i)}}):console.info("Cancelado")})}deleteEstante(e){console.info("deleteServicio",e),this.apiClient.deleteRequest(e.id,"/api/estante").subscribe({next:o=>{this.getEstantes()},error:o=>{console.info(o)}})}onFilterChange(e){console.info(event),this.dataSource&&(e=(e=e.trim()).toLowerCase(),this.dataSource.filter=e)}static{this.\u0275fac=function(o){return new(o||n)(t.rXU(v.f),t.rXU(g.bZ))}}static{this.\u0275cmp=t.VBU({type:n,selectors:[["fury-estante"]],decls:20,vars:9,consts:[["mode","card"],["current","Estante",3,"crumbs"],["name","Estante",3,"columns","filterChange"],[1,"actions"],["type","button","mat-mini-fab","","color","primary",1,"create",3,"click"],["mat-table","","matSort","",3,"dataSource"],["matColumnDef","checkbox"],["class","actions-cell","mat-header-cell","",4,"matHeaderCellDef"],["class","actions-cell","mat-cell","",4,"matCellDef"],[4,"ngFor","ngForOf"],["matColumnDef","actions"],["class","actions-cell","mat-header-cell","","mat-sort-header","",4,"matHeaderCellDef"],["mat-header-row","",4,"matHeaderRowDef"],["class","clickable route-animations-elements","mat-row","",3,"click",4,"matRowDef","matRowDefColumns"],[1,"paginator",3,"pageSize"],["mat-header-cell","",1,"actions-cell"],["color","primary",3,"click"],["mat-cell","",1,"actions-cell"],[3,"matColumnDef",4,"ngIf"],[3,"matColumnDef"],["mat-header-cell","","mat-sort-header","",4,"matHeaderCellDef"],["mat-cell","",4,"matCellDef"],["mat-header-cell","","mat-sort-header",""],["mat-cell",""],["mat-header-cell","","mat-sort-header","",1,"actions-cell"],["type","button","mat-icon-button","",3,"matMenuTriggerFor","click"],["yPosition","below","xPosition","before"],["actionsMenu","matMenu"],["mat-menu-item","",3,"click"],["mat-header-row",""],["mat-row","",1,"clickable","route-animations-elements",3,"click"]],template:function(o,i){1&o&&(t.j41(0,"fury-page-layout",0)(1,"fury-page-layout-header"),t.nrm(2,"fury-breadcrumbs",1),t.k0s(),t.j41(3,"fury-page-layout-content")(4,"fury-list",2),t.bIt("filterChange",function(l){return i.onFilterChange(l)}),t.j41(5,"div",3)(6,"button",4),t.bIt("click",function(){return i.createEstante()}),t.j41(7,"mat-icon"),t.EFF(8,"add"),t.k0s()()(),t.j41(9,"table",5),t.qex(10,6),t.DNE(11,$,2,0,"th",7),t.DNE(12,T,2,0,"td",8),t.bVm(),t.DNE(13,M,2,1,"ng-container",9),t.qex(14,10),t.DNE(15,I,1,0,"th",11),t.DNE(16,N,12,1,"td",8),t.bVm(),t.DNE(17,Y,1,0,"tr",12),t.DNE(18,V,1,0,"tr",13),t.k0s(),t.nrm(19,"mat-paginator",14),t.k0s()()()),2&o&&(t.R7$(2),t.Y8G("crumbs",t.lJ4(7,_)),t.R7$(2),t.Y8G("columns",t.lJ4(8,X)),t.R7$(5),t.Y8G("dataSource",i.dataSource),t.R7$(4),t.Y8G("ngForOf",i.columns),t.R7$(4),t.Y8G("matHeaderRowDef",i.visibleColumns),t.R7$(1),t.Y8G("matRowDefColumns",i.visibleColumns),t.R7$(1),t.Y8G("pageSize",i.pageSize))},dependencies:[m.Sq,m.bT,D.m,x.s,u.iY,u.$0,E.So,b.An,p.kk,p.fb,p.Cp,y.iy,f.B4,f.aE,s.Zl,s.tL,s.ji,s.cC,s.YV,s.iL,s.KS,s.$R,s.YZ,s.NB,j.T,F.M,R.M]})}}return n})()}];let H=(()=>{class n{static{this.\u0275fac=function(o){return new(o||n)}}static{this.\u0275mod=t.$C({type:n})}static{this.\u0275inj=t.G2t({imports:[h.iI.forChild(P),h.iI]})}}return n})();var z=a(3632),B=a(91398),A=a(49320),O=a(52920),L=a(86467),U=a(99631),Z=a(89417);let J=(()=>{class n{static{this.\u0275fac=function(o){return new(o||n)}}static{this.\u0275mod=t.$C({type:n})}static{this.\u0275inj=t.G2t({imports:[m.MD,O.w2,u.Hl,g.hM,L.RG,U.fS,Z.X1]})}}return n})(),K=(()=>{class n{static{this.\u0275fac=function(o){return new(o||n)}}static{this.\u0275mod=t.$C({type:n})}static{this.\u0275inj=t.G2t({imports:[m.MD,H,z.V,B.H,u.Hl,E.g7,b.m_,p.Cn,y.Ou,f.NQ,s.tP,A.S,J]})}}return n})()}}]);