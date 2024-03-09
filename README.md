How to run the project (example)

```bash
minikube start
```

```bash
kubectl create secret generic database-secrets --from-literal=username=test
--from-literal=password='test' --from-literal=database='test'
```

```bash
kubectl create secret generic grafana --from-literal=gf_security_admin_user='admin'
 --from-literal=gf_security_admin_password='grafana'
```

```bash
cd .\monitoring\
```

```bash
kubectl apply -f deployment.yaml
```

```bash
kubectl port-forward sergeyttser-api-6dbcffcb87-d28zg 8080:8080 (replace with your pod name)
```

```bash
kubectl port-forward sergeyttser-api-6dbcffcb87-d28zg 9091:9091 (replace with your pod name)
```
