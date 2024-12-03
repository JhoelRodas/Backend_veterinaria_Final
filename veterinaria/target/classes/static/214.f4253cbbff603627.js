"use strict";(self.webpackChunkfury=self.webpackChunkfury||[]).push([[214],{88214:(ot,b,n)=>{n.r(b),n.d(b,{ProductoModule:()=>tt});var d=n(60177),P=n(18498),s=n(9159),c=n(89417),m=n(34006),t=n(17705),y=n(97405),f=n(52920),p=n(88834),C=n(86467),v=n(99631),F=n(86600),k=n(82798);function $(e,a){if(1&e&&(t.j41(0,"mat-option",12),t.EFF(1),t.k0s()),2&e){const o=a.$implicit;t.Y8G("value",o.id),t.R7$(1),t.SpI(" ",o.nombre," ")}}function G(e,a){if(1&e&&(t.j41(0,"button",13),t.EFF(1,"Crear Producto "),t.k0s()),2&e){const o=t.XpG();t.Y8G("disabled",!o.form.valid)}}function T(e,a){if(1&e&&(t.j41(0,"button",13),t.EFF(1,"Actualizar Producto "),t.k0s()),2&e){const o=t.XpG();t.Y8G("disabled",!o.form.valid)}}let j=(()=>{class e{constructor(o,r,i){this.defaults=o,this.dialogRef=r,this.apiClient=i,this.mode="create",this.categoriaList=[]}ngOnInit(){this.defaults?this.mode="update":this.defaults={},this.form=new c.J3({nombre:new c.hs(this.defaults.nombre),precioUnitario:new c.hs(this.defaults.precioUnitario),stock:new c.hs(this.defaults.stock),descripcion:new c.hs(this.defaults.descripcion),idCategoria:new c.hs(this.defaults.idCategoria)}),this.apiClient.getRequest("/api/categoria").subscribe({next:o=>{this.categoriaList=o,console.info(o)},error:o=>{console.error(o)}})}save(){console.log(this.form.value),"create"===this.mode?this.createCustomer():"update"===this.mode&&this.updateCustomer()}createCustomer(){this.dialogRef.close(this.form.value)}updateCustomer(){const o=this.form.value;o.id=this.defaults.id,this.dialogRef.close(o)}isCreateMode(){return"create"===this.mode}isUpdateMode(){return"update"===this.mode}static{this.\u0275fac=function(r){return new(r||e)(t.rXU(m.Vh),t.rXU(m.CP),t.rXU(y.f))}}static{this.\u0275cmp=t.VBU({type:e,selectors:[["fury-crear-actualizar-producto"]],decls:29,vars:5,consts:[["mat-dialog-title",""],[3,"formGroup","ngSubmit"],["fxLayout","column wrap"],["fxFlex",""],["type","text","formControlName","nombre","matInput",""],["type","text","formControlName","precioUnitario","matInput",""],["type","text","formControlName","stock","matInput",""],["type","text","formControlName","descripcion","matInput",""],["formControlName","idCategoria"],[3,"value",4,"ngFor","ngForOf"],["fxLayout","row","fxLayoutAlign","end center"],["mat-flat-button","","color","primary",3,"disabled",4,"ngIf"],[3,"value"],["mat-flat-button","","color","primary",3,"disabled"]],template:function(r,i){1&r&&(t.j41(0,"div",0),t.EFF(1),t.k0s(),t.j41(2,"form",1),t.bIt("ngSubmit",function(){return i.save()}),t.j41(3,"mat-dialog-content")(4,"div",2)(5,"mat-form-field",3)(6,"mat-label"),t.EFF(7,"Nombre"),t.k0s(),t.nrm(8,"input",4),t.k0s(),t.j41(9,"mat-form-field",3)(10,"mat-label"),t.EFF(11,"Precio Unitario"),t.k0s(),t.nrm(12,"input",5),t.k0s(),t.j41(13,"mat-form-field",3)(14,"mat-label"),t.EFF(15,"Stock"),t.k0s(),t.nrm(16,"input",6),t.k0s(),t.j41(17,"mat-form-field",3)(18,"mat-label"),t.EFF(19,"Descripcion"),t.k0s(),t.nrm(20,"input",7),t.k0s(),t.j41(21,"mat-form-field")(22,"mat-label"),t.EFF(23,"Categoria"),t.k0s(),t.j41(24,"mat-select",8),t.DNE(25,$,2,2,"mat-option",9),t.k0s()()()(),t.j41(26,"mat-dialog-actions",10),t.DNE(27,G,2,1,"button",11),t.DNE(28,T,2,1,"button",11),t.k0s()()),2&r&&(t.R7$(1),t.SpI("",i.isCreateMode()?"Crear":"Actualizar"," Producto"),t.R7$(1),t.Y8G("formGroup",i.form),t.R7$(23),t.Y8G("ngForOf",i.categoriaList),t.R7$(2),t.Y8G("ngIf",i.isCreateMode()),t.R7$(1),t.Y8G("ngIf",i.isUpdateMode()))},dependencies:[d.Sq,d.bT,f.DJ,f.sA,f.UI,c.qT,c.me,c.BC,c.cb,p.$z,m.BI,m.Yi,m.E7,C.rl,C.nJ,v.fg,c.j4,c.JD,F.wT,k.VO]})}}return e})();var E=n(74061),I=n(75063),x=n(82765),D=n(99213),h=n(59115),R=n(96695),g=n(2042),S=n(43655),M=n(53007),N=n(15551);function _(e,a){1&e&&(t.j41(0,"th",15)(1,"mat-checkbox",16),t.bIt("click",function(r){return r.stopPropagation()}),t.k0s()())}function Y(e,a){1&e&&(t.j41(0,"td",17)(1,"mat-checkbox",16),t.bIt("click",function(r){return r.stopPropagation()}),t.k0s()())}function z(e,a){if(1&e&&(t.j41(0,"th",22),t.EFF(1),t.k0s()),2&e){const o=t.XpG(2).$implicit;t.R7$(1),t.SpI(" ",o.name,"")}}function U(e,a){if(1&e&&(t.j41(0,"td",23),t.EFF(1),t.k0s()),2&e){const o=a.$implicit,r=t.XpG(2).$implicit;t.R7$(1),t.SpI(" ",o[r.property]," ")}}function V(e,a){if(1&e&&(t.qex(0,19),t.DNE(1,z,2,1,"th",20),t.DNE(2,U,2,1,"td",21),t.bVm()),2&e){const o=t.XpG().$implicit;t.Y8G("matColumnDef",o.property)}}function A(e,a){if(1&e&&(t.qex(0),t.DNE(1,V,3,1,"ng-container",18),t.bVm()),2&e){const o=a.$implicit;t.R7$(1),t.Y8G("ngIf",o.isModelProperty)}}function X(e,a){1&e&&t.nrm(0,"th",24)}function B(e,a){if(1&e){const o=t.RV6();t.j41(0,"td",17)(1,"button",25),t.bIt("click",function(i){return i.stopPropagation()}),t.j41(2,"mat-icon"),t.EFF(3,"more_horiz"),t.k0s()(),t.j41(4,"mat-menu",26,27)(6,"button",28),t.bIt("click",function(){const l=t.eBV(o).$implicit,u=t.XpG();return t.Njj(u.updateProducto(l))}),t.j41(7,"span"),t.EFF(8,"Modify"),t.k0s()(),t.j41(9,"button",28),t.bIt("click",function(){const l=t.eBV(o).$implicit,u=t.XpG();return t.Njj(u.deleteProducto(l))}),t.j41(10,"span"),t.EFF(11,"Delete"),t.k0s()()()()}if(2&e){const o=t.sdS(5);t.R7$(1),t.Y8G("matMenuTriggerFor",o)}}function L(e,a){1&e&&t.nrm(0,"tr",29)}function O(e,a){if(1&e){const o=t.RV6();t.j41(0,"tr",30),t.bIt("click",function(){const l=t.eBV(o).$implicit,u=t.XpG();return t.Njj(u.updateProducto(l))}),t.k0s()}}const H=function(){return["Productos"]},w=function(){return[]},J=[{path:"",component:(()=>{class e{ngOnInit(){this.getProducto()}get visibleColumns(){return this.columns.filter(o=>o.visible).map(o=>o.property)}constructor(o,r){this.apiClient=o,this.dialog=r,this.dataSource=new s.I6([]),this.columns=[{name:"ID",property:"id",visible:!0,isModelProperty:!0},{name:"Nombre",property:"nombre",visible:!0,isModelProperty:!0},{name:"Precio Unitario",property:"precioUnitario",visible:!0,isModelProperty:!0},{name:"Stock",property:"stock",visible:!0,isModelProperty:!0},{name:"Descripcion",property:"descripcion",visible:!0,isModelProperty:!0},{name:"Categoria",property:"nombreCategoria",visible:!0,isModelProperty:!0},{name:"Actions",property:"actions",visible:!0}],this.pageSize=10}getProducto(){this.apiClient.getRequest("/api/producto").subscribe({next:o=>{this.dataSource.data=o,console.log(o)},error:o=>{console.error(o)}})}onFilterChange(o){console.info(event),this.dataSource&&(o=(o=o.trim()).toLowerCase(),this.dataSource.filter=o)}createProducto(){console.info("Abre dialogo"),this.dialog.open(j,{width:"400px"}).afterClosed().subscribe(o=>{o?(console.info("Al crear el dialogo de crear",o),this.apiClient.postRequest("/api/producto",o).subscribe({next:r=>{console.info("OK",r),this.getProducto()},error:r=>{console.error("error",r)}}),console.info("Fin api call")):console.info("Cancelado")}),console.info("Fin Metodo")}deleteProducto(o){this.apiClient.deleteRequest(o.id,"/api/producto").subscribe({next:r=>{this.getProducto()},error:r=>{}})}updateProducto(o){console.info(o),this.dialog.open(j,{data:o,width:"400px"}).afterClosed().subscribe(r=>{r?this.apiClient.putRequest("/api/producto",r.id,r).subscribe({next:i=>{this.getProducto()},error:i=>{console.error(i)}}):console.info("Cancelado")})}static{this.\u0275fac=function(r){return new(r||e)(t.rXU(y.f),t.rXU(m.bZ))}}static{this.\u0275cmp=t.VBU({type:e,selectors:[["fury-producto"]],decls:20,vars:9,consts:[["mode","card"],["current","Producto",3,"crumbs"],["name","Productos",3,"columns","filterChange"],[1,"actions"],["type","button","mat-mini-fab","","color","primary",1,"create",3,"click"],["mat-table","","matSort","",3,"dataSource"],["matColumnDef","checkbox"],["class","actions-cell","mat-header-cell","",4,"matHeaderCellDef"],["class","actions-cell","mat-cell","",4,"matCellDef"],[4,"ngFor","ngForOf"],["matColumnDef","actions"],["class","actions-cell","mat-header-cell","","mat-sort-header","",4,"matHeaderCellDef"],["mat-header-row","",4,"matHeaderRowDef"],["class","clickable route-animations-elements","mat-row","",3,"click",4,"matRowDef","matRowDefColumns"],[1,"paginator",3,"pageSize"],["mat-header-cell","",1,"actions-cell"],["color","primary",3,"click"],["mat-cell","",1,"actions-cell"],[3,"matColumnDef",4,"ngIf"],[3,"matColumnDef"],["mat-header-cell","","mat-sort-header","",4,"matHeaderCellDef"],["mat-cell","",4,"matCellDef"],["mat-header-cell","","mat-sort-header",""],["mat-cell",""],["mat-header-cell","","mat-sort-header","",1,"actions-cell"],["type","button","mat-icon-button","",3,"matMenuTriggerFor","click"],["yPosition","below","xPosition","before"],["actionsMenu","matMenu"],["mat-menu-item","",3,"click"],["mat-header-row",""],["mat-row","",1,"clickable","route-animations-elements",3,"click"]],template:function(r,i){1&r&&(t.j41(0,"fury-page-layout",0)(1,"fury-page-layout-header"),t.nrm(2,"fury-breadcrumbs",1),t.k0s(),t.j41(3,"fury-page-layout-content")(4,"fury-list",2),t.bIt("filterChange",function(u){return i.onFilterChange(u)}),t.j41(5,"div",3)(6,"button",4),t.bIt("click",function(){return i.createProducto()}),t.j41(7,"mat-icon"),t.EFF(8,"add"),t.k0s()()(),t.j41(9,"table",5),t.qex(10,6),t.DNE(11,_,2,0,"th",7),t.DNE(12,Y,2,0,"td",8),t.bVm(),t.DNE(13,A,2,1,"ng-container",9),t.qex(14,10),t.DNE(15,X,1,0,"th",11),t.DNE(16,B,12,1,"td",8),t.bVm(),t.DNE(17,L,1,0,"tr",12),t.DNE(18,O,1,0,"tr",13),t.k0s(),t.nrm(19,"mat-paginator",14),t.k0s()()()),2&r&&(t.R7$(2),t.Y8G("crumbs",t.lJ4(7,H)),t.R7$(2),t.Y8G("columns",t.lJ4(8,w)),t.R7$(5),t.Y8G("dataSource",i.dataSource),t.R7$(4),t.Y8G("ngForOf",i.columns),t.R7$(4),t.Y8G("matHeaderRowDef",i.visibleColumns),t.R7$(1),t.Y8G("matRowDefColumns",i.visibleColumns),t.R7$(1),t.Y8G("pageSize",i.pageSize))},dependencies:[d.Sq,d.bT,E.m,I.s,p.iY,p.$0,x.So,D.An,h.kk,h.fb,h.Cp,R.iy,g.B4,g.aE,s.Zl,s.tL,s.ji,s.cC,s.YV,s.iL,s.KS,s.$R,s.YZ,s.NB,S.T,M.M,N.M]})}}return e})()}];let Z=(()=>{class e{static{this.\u0275fac=function(r){return new(r||e)}}static{this.\u0275mod=t.$C({type:e})}static{this.\u0275inj=t.G2t({imports:[P.iI.forChild(J),P.iI]})}}return e})();var K=n(3632),Q=n(91398),W=n(49320);let q=(()=>{class e{static{this.\u0275fac=function(r){return new(r||e)}}static{this.\u0275mod=t.$C({type:e})}static{this.\u0275inj=t.G2t({imports:[d.MD,f.w2,c.YN,p.Hl,m.hM,C.RG,v.fS,c.X1,F.Sy,k.Ve]})}}return e})(),tt=(()=>{class e{static{this.\u0275fac=function(r){return new(r||e)}}static{this.\u0275mod=t.$C({type:e})}static{this.\u0275inj=t.G2t({imports:[d.MD,Z,K.V,Q.H,p.Hl,x.g7,D.m_,h.Cn,R.Ou,g.NQ,s.tP,W.S,q]})}}return e})()}}]);